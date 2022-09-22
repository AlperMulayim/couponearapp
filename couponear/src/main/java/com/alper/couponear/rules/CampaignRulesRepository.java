package com.alper.couponear.rules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignRulesRepository  extends JpaRepository<CampaignRule, Integer> {
    Optional<CampaignRule> findById(Integer id);
}
