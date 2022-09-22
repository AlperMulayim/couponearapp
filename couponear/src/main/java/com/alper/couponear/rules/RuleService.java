package com.alper.couponear.rules;

import com.alper.couponear.campaing.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
