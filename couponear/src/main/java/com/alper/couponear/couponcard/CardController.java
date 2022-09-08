package com.alper.couponear.couponcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    @Autowired
    private  CouponCardService service;

    @GetMapping
    public List<CouponCard> getCards(){
        return  service.getCards();
    }
}
