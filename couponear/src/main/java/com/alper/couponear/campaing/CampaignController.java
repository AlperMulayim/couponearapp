package com.alper.couponear.campaing;

import com.alper.couponear.rules.CampaignRule;
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

    @GetMapping("/{id}/rules")
    public ResponseEntity<List<CampaignRule>> getRulesOfCampaign(@PathVariable(name = "id") String  uid){
        Optional<List<CampaignRule>> rulesOp = campaignService.getRules(uid);

        if(rulesOp.isPresent()){
            return ResponseEntity.ok(rulesOp.get());
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
     }

     @PostMapping("/{id}/rules")
    public ResponseEntity<List<CampaignRule>> updateRulesOfCampaign(@PathVariable(name = "id") String uid,
                                                                    @RequestBody List<CampaignRule> rules){
            return ResponseEntity.ok(campaignService.addRulesToCampaing(uid,rules));
     }

     @DeleteMapping("/{id}/rules")
    public ResponseEntity<List<CampaignRule>> deleteRules(@PathVariable(name = "id") String uid){
        return ResponseEntity.ok(campaignService.deleteRules(uid));
     }
}
