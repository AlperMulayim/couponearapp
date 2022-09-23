package com.alper.couponear.historysystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponearHistoryRepository  extends JpaRepository<CouponearHistory,Integer> {
}
