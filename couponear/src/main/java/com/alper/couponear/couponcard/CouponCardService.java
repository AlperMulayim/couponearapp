package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import com.alper.couponear.campaing.CampaignRepository;
import com.alper.couponear.campaing.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponCardService {
    @Autowired
    private  CouponCardRepository cardRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    public List<CouponCard> getCards(){
        return  this.cardRepository.findAll();
    }

    public CouponCard saveCards(CouponCard card){
        return  this.cardRepository.save(card);
    }

    public CouponCard generateAndSaveCard(Campaign campaign){

            Random random = new Random();
            UUID uuid = UUID.randomUUID();

            String barcodeBegin = Integer.toHexString(random.nextInt(100)  % 11);
            String barcodeEnd= uuid.toString().toUpperCase().substring(0,4);

            String barcode = "CP"+ campaign.getOwnerId() + "-" + barcodeBegin.toUpperCase() +"-" + barcodeEnd;

            CouponCard card = CouponCard.builder()
                    .campaingId(campaign.getId())
                    .createDate(campaign.getCreateDate())
                    .expireDate(campaign.getExpireDate())
                    .campaingName(campaign.getName())
                    .barcode(barcode)
                    .build();

            return cardRepository.save(card);
        }

        public Optional<CouponCard> createUserCard(String campaignUid){
            CouponCard card = null;
            Optional<Campaign> campaign = campaignRepository.findByUid(campaignUid);

            if (campaign.isPresent()){
               card =  this.generateAndSaveCard(campaign.get());
               campaign.get().setNumOfCards(campaign.get().getNumOfCards() -1);
               campaignRepository.save(campaign.get());
            }
            return  Optional.of(card);
        }
}
