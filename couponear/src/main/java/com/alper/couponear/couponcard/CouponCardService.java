package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import com.alper.couponear.campaing.CampaignRepository;

import com.alper.couponear.company.Company;
import com.alper.couponear.company.CompanyRepository;
import com.alper.couponear.rules.CampaignRule;
import com.alper.couponear.users.User;
import com.alper.couponear.users.UserRepository;
import org.apache.tomcat.util.digester.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CouponCardService {
    @Autowired
    private  CouponCardRepository cardRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CouponCard> getCards(){
        return  this.cardRepository.findAll();
    }

    public CouponCard saveCards(CouponCard card){
        return  this.cardRepository.save(card);
    }

    public CouponCard generateAndSaveCard(Campaign campaign, User user){

            Random random = new Random();
            UUID uuid = UUID.randomUUID();

            String barcodeBegin = Integer.toHexString(random.nextInt(100)  % 11);
            String barcodeEnd= uuid.toString().toUpperCase().substring(0,4);

            String barcode = "CP"+ campaign.getOwnerId() + "-" + barcodeBegin.toUpperCase() +"-" + barcodeEnd;
            Date createDate = Date.from(LocalDateTime.now().toInstant( ZoneId.of("Europe/Berlin").getRules().getOffset(Instant.now())));
            Company company = companyRepository.findById(campaign.getOwnerId()).get();
            CouponCard card = CouponCard.builder()
                        .companyId(campaign.getOwnerId())
                        .campaingId(campaign.getId())
                        .company(company)
                        .createDate(createDate)
                        .expireDate(campaign.getExpireDate())
                        .campaingName(campaign.getName())
                        .barcode(barcode)
                        .userId(user.getId())
                        .build();

            return cardRepository.save(card);
        }

        public Optional<CouponCard> createUserCard(String campaignUid, String userUid){
            Optional<CouponCard> card = Optional.empty();
            Optional<Campaign> campaign = campaignRepository.findByUid(campaignUid);
            Optional<User> user = userRepository.findByUid(userUid);

            if (campaign.isPresent() && user.isPresent()){
               card =  Optional.of(this.generateAndSaveCard(campaign.get(),user.get()));
               campaign.get().setNumOfCards(campaign.get().getNumOfCards() -1);
               campaignRepository.save(campaign.get());
            }
            return  card;
        }

        public GeneratedCouponCardDetails generateCouponCard(String campaignId, String userId){
            GeneratedCouponCardDetails cardDetails = null;

            Optional<CouponCard> generatedUserCard = createUserCard(campaignId,userId);

            Campaign  campaign = campaignRepository.findByUid(campaignId).get();
            String rules = campaign.getRules().stream()
                    .map(CampaignRule::getRuleName)
                    .collect(Collectors.joining(" | "));
            if(generatedUserCard.isPresent()){
                CouponCard card = generatedUserCard.get();
                cardDetails = GeneratedCouponCardDetails.builder()
                        .cardBarcode(card.getBarcode())
                        .companyName(card.getCompany().getName())
                        .expireDate(card.getExpireDate().toString())
                        .details(campaign.getDetail())
                        .rules(rules)
                        .build();
            }
            return cardDetails;
        }
        public Optional<CouponCard> validateCard(String barcode){
            Optional<CouponCard> card = Optional.empty();

            card = cardRepository.findByBarcode(barcode);

            if(card.isPresent()){
                Date usedDate = Date.from(LocalDateTime.now().toInstant( ZoneId.of("Europe/Berlin").getRules().getOffset(Instant.now())));
                if(card.get().getUsedDate() == null){
                    card.get().setUsedDate(usedDate);
                    cardRepository.save(card.get());
                }
            }
            //add exception for used card not used again;
            return card;
        }

        public CouponCard gitfCard(){
            List<CouponCard> cardsNotAssigned = cardRepository.findByUserId(null);
            Random random = new Random();
            Integer index = random.ints(0,cardsNotAssigned.size()).findFirst().getAsInt();
            return cardsNotAssigned.get(index);
        }

        public CouponCard approveGift(CouponCard card){
            return  saveCards(card);
        }
}
