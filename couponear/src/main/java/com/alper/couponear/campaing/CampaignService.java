package com.alper.couponear.campaing;

import com.alper.couponear.couponcard.CouponCard;
import com.alper.couponear.couponcard.CouponCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository repository;

    @Autowired
    private CouponCardService cardService;

    public List<Campaign> getCampaigns(){
        return repository.findAll();
    }

    public Campaign saveCampaign(Campaign campaign) {
        Campaign newCamp = repository.save(campaign);
        CouponCard card = cardService.generateAndSaveCard(newCamp);

        if (card != null) {
            campaign.setNumOfCards(campaign.getNumOfCards() - 1);
            repository.save(campaign);
        }
        return newCamp;
    }

    public Optional<Campaign> getCampaign(String campaignUid){
     return repository.findByUid(campaignUid);
    }

    public Optional<CampaignDetail> getCampaignDetail(String campaignUid){
        Optional<Campaign> campaign = getCampaign(campaignUid);

        Optional<CampaignDetail> campaignDetailOp = Optional.empty();

        if(campaign.isPresent()){
            List<CouponCard> cards = cardService.getCards();
            cards = cards.stream().filter(card -> card.getUsedDate() != null).collect(Collectors.toList());

            CampaignStatistic campaignStatistic =  CampaignStatistic.builder()
                    .totalCard(campaign.get().getNumOfCards())
                    .usedCard(cards.size())
                    .build();

            CampaignDetail campaignDetail = CampaignDetail.builder()
                    .campaign(campaign.get())
                    .statistic(campaignStatistic)
                    .build();

            campaignDetailOp = Optional.of(campaignDetail);

        }
        return  campaignDetailOp;
    }
}
