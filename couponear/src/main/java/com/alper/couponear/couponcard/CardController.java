package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    @Autowired
    private  CouponCardService service;

    @GetMapping
    public List<CouponCard> getCards(){
        return  service.getCards();
    }

    @PostMapping
    public CouponCard saveCard(@RequestBody CouponCard card){
        return  service.saveCards(card);
    }

    @PostMapping("/generate")
    public List<CouponCard> generateCards(@RequestBody Campaign cardInfo){
        return null;
    }
}
