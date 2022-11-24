package com.alper.couponear.rabbitmq.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    @RabbitListener(queues = {"notification_queue"})
    public void receive(@Payload String text){
        System.out.println("Received NOTIFICATION -> " + text);
    }

}
