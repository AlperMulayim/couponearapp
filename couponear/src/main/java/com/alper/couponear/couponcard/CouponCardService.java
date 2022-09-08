package com.alper.couponear.couponcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponCardService {
    @Autowired
    private  CouponCardRepository cardRepository;

    public List<CouponCard> getCards(){
        return  this.cardRepository.findAll();
    }

}
