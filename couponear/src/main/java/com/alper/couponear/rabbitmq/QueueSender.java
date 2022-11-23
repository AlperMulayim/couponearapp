package com.alper.couponear.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;


@Component
public class QueueSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public  void  send(String mes){
        template.convertAndSend("exchange.64c102c1-74f9-4ecc-ad2f-6954753b22c2", "64c102c1-74f9-4ecc-ad2f-6954753b22c2", mes);
        //template.convertAndSend(queue.getName(),mes);
    }

}
