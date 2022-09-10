package com.alper.couponear.campaing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<CampaignDetail> getCampaign(@PathVariable(name = "id") String  uid){
        Optional<CampaignDetail> campaignDetail =  campaignService.getCampaignDetail(uid);
        if(campaignDetail.isPresent()){
            return ResponseEntity.ok(campaignDetail.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
