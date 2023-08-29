package com.alper.couponear.couponcard;

import com.alper.couponear.campaing.Campaign;
import com.alper.couponear.rabbitmq.QueueSender;
import com.alper.couponear.rabbitmq.notification.NotificationPublisher;
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

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private NotificationPublisher notificationPublisher;
    @GetMapping
    public List<CouponCard> getCards(){
        return  service.getCards();
    }

    @PostMapping
    public CouponCard saveCard(@RequestBody CouponCard card){
        return  service.saveCards(card);
    }

    @PostMapping("/generate")
    public ResponseEntity<GeneratedCouponCardDetails> generateCard(
            @RequestParam(name = "campaignUid", required = true) Optional<String> campaignUid,
            @RequestParam(name = "userid",required = true) Optional<String> userUid
    ) {
        return ResponseEntity.ok(service.generateCouponCard(campaignUid.get(),userUid.get()));
    }

    @PostMapping("/validate")
    public ResponseEntity<CouponCard> cardValidate(@RequestParam(name = "barcode",required = true)  Optional<String> barcode){

        if(barcode.isPresent()) {
            Optional<CouponCard> card = service.validateCard(barcode.get());
            if (card.isPresent()) {
                notificationPublisher.send("CARD VALIDATED...-> " +card.get().toString());
                return ResponseEntity.ok(card.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @GetMapping("/gift")
    public ResponseEntity<CouponCard> getGiftCard(){
        return  ResponseEntity.ok(service.gitfCard());
    }

    @PostMapping("/gift")
    public ResponseEntity<CouponCard> getGiftCard(@RequestBody CouponCard card){
            return ResponseEntity.ok( this.service.approveGift(card));
    }
}
