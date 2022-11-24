package com.alper.couponear.rabbitmq.notification;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Qualifier("notification_queue_config")
public class NotificationQueueConfig {

    @Bean(name = "notification_queue")
    @Primary
    public Queue notificationQueue(){
        return new Queue("notification_queue",true);
    }

    @Bean(name = "notification_exchange")
    @Primary
    public DirectExchange directExchange(){
        return new DirectExchange("notification-exchange");
    }

    @Bean(name = "notification_bindings")
    @Primary
    public Declarables directExchangeBindings(){
        return new Declarables(BindingBuilder.bind(notificationQueue()).to(directExchange()).with("notifications_keys"));
    }
}
