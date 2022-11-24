package com.alper.couponear.rabbitmq.notification;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("NotificationPublisher")
public class NotificationPublisher {

    @Autowired
    private RabbitTemplate template;

    @Qualifier("notification_queue")
    @Autowired
    private Queue notificationQueue;

    @Qualifier("notification_exchange")
    @Autowired
    private DirectExchange notificatinExchange;

    public void send(String message){
        template.convertAndSend(notificatinExchange.getName(),"notifications_keys", message);
    }
}
