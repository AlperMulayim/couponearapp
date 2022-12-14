package com.alper.couponear.rules;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rules")
public class RuleController {

    @Autowired
    private  RuleService ruleService;

    @GetMapping
    public List<CampaignRule> getRules(@RequestParam(name = "type", required = false)  Optional<CampaignRuleType> type){
        List<CampaignRule> rules = ruleService.getRules();

        if(type.isPresent()){
            rules = rules.stream()
                    .filter(campaignRule -> campaignRule.getCampaignRuleType().equals(type.get()))
                    .collect(Collectors.toList());
        }
        return rules;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignRule> getRule(@PathVariable(name = "id") Integer id){
        Optional<CampaignRule> ruleOp = ruleService.getRule(id);

        if(ruleOp.isPresent()){
            return ResponseEntity.ok(ruleOp.get());
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PatchMapping
    public ResponseEntity< CampaignRule> updateRuleName(@RequestParam(name = "id") Integer id,
                                                        @RequestParam(name = "name") String newName){
        Optional<CampaignRule> ruleOp =  ruleService.updateRuleName(id,newName);
        if(ruleOp.isPresent()){
            return  ResponseEntity.ok(ruleOp.get());
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<CampaignRule> addRules(@RequestBody CampaignRule rule){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ruleService.addRule(rule));
    }


}
