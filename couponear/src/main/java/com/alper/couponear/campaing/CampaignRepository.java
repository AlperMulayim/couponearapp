package com.alper.couponear.campaing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    Campaign save(Campaign campaign);
    Optional<Campaign> findByUid(String uid);
}
