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
        template.convertAndSend(queue.getName(),mes);
    }

}
