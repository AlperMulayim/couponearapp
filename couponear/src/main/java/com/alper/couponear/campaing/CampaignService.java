package com.alper.couponear.campaing;

import com.alper.couponear.couponcard.CouponCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository repository;

    @Autowired
    private CouponCardService cardService;

    public List<Campaign> getCampaigns(){
        return repository.findAll();
    }

    public Campaign saveCampaign(Campaign campaign){
        Campaign newCamp =  repository.save(campaign);
        cardService.generateAndSaveCards(newCamp);
        return newCamp;
    }
}
