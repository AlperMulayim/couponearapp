package com.alper.couponear.couponcard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CouponCardRepository  extends JpaRepository<CouponCard,Integer> {
    CouponCard save(CouponCard card);
    Optional<CouponCard> findByBarcode(String barcode);
    List<CouponCard> findByUserId(Integer id);

}
