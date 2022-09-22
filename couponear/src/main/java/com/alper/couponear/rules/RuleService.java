package com.alper.couponear.rules;

import com.alper.couponear.campaing.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RuleService {
    @Autowired
    private CampaignRulesRepository repository;

    public List<CampaignRule> getRules(){
        return repository.findAll();
    }
    public Optional<CampaignRule> getRule(Integer ruleId){
        return repository.findById(ruleId);
    }

    public Optional<CampaignRule> updateRuleName(Integer id,String name){
        Optional<CampaignRule> ruleOp = getRule(id);

        if(ruleOp.isPresent()){
            CampaignRule rule = ruleOp.get();
            rule.setRuleName(name);
            rule.setUpdateDate(new Date());
            repository.save(rule);
            ruleOp = Optional.of(rule);
        }
        return  ruleOp;
    }
}
