package com.alper.couponear.campaing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public List<Campaign> getAll(){
        return  this.campaignService.getCampaigns();
    }

    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign){
        return this.campaignService.saveCampaign(campaign);
    }
}
