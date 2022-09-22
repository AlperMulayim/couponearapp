package com.alper.couponear.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/rules")
public class RuleController {

    @Autowired
    private  RuleService ruleService;

    @GetMapping
    public List<CampaignRule> getRules(){
        return ruleService.getRules();
    }
}
