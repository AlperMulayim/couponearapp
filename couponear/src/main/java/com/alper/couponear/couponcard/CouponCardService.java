package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponCardService {
    @Autowired
    private  CouponCardRepository cardRepository;

    public List<CouponCard> getCards(){
        return  this.cardRepository.findAll();
    }

    public CouponCard saveCards(CouponCard card){
        return  this.cardRepository.save(card);
    }

    public void generateAndSaveCards(Campaign campaign){
        Integer numOfCards = campaign.getNumOfCards();
        List<CouponCard> cards = new LinkedList<>();

        for(int i = 0; i < numOfCards; ++i){
            Random random = new Random();

            UUID uuid = UUID.randomUUID();

            String barcodeBegin = Integer.toHexString(random.nextInt(100) + i % 11);
            String barcodeEnd= uuid.toString().toUpperCase().substring(0,4);


            String barcode = "CP"+ campaign.getOwnerId() + "-" + barcodeBegin.toUpperCase() +"-" + barcodeEnd;


            CouponCard card = CouponCard.builder()
                    .campaingId(campaign.getId())
                    .createDate(campaign.getCreateDate())
                    .expireDate(campaign.getExpireDate())
                    .campaingName(campaign.getName())
                    .barcode(barcode)
                    .build();
            cards.add(card);
        }
        cardRepository.saveAll(cards);
    }
}
