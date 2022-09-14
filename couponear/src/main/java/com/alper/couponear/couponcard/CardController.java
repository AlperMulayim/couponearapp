package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<CouponCard> generateCard(
            @RequestParam(name = "campaignUid", required = true) Optional<String> campaignUid,
            @RequestParam(name = "userid",required = true) Optional<String> userUid
    ) {
        if (campaignUid.isPresent() && userUid.isPresent()) {
           Optional<CouponCard> card = service.createUserCard(campaignUid.get(),userUid.get());
           if(card.isPresent()){
               return ResponseEntity.ok(card.get());
           }
           return  ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<CouponCard> cardValidate(@RequestParam(name = "barcode",required = true)  Optional<String> barcode){

        if(barcode.isPresent()) {
            Optional<CouponCard> card = service.validateCard(barcode.get());
            if (card.isPresent()) {
                return ResponseEntity.ok(card.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
}
