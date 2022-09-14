package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import com.alper.couponear.campaing.CampaignRepository;

import com.alper.couponear.company.CompanyRepository;
import com.alper.couponear.users.User;
import com.alper.couponear.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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

            CouponCard card = CouponCard.builder()
                        .companyId(campaign.getOwnerId())
                        .campaingId(campaign.getId())
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
}
