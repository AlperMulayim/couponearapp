package com.alper.couponear.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
    @RabbitListener(queues = {"my-queue"})
    public void receive(@Payload String text){
        System.out.println("Received message -> " + text);
    }
}
