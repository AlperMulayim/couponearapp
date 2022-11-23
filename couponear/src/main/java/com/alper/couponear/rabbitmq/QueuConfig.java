package com.alper.couponear.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueuConfig {

    @Bean
    public Queue queue(){
        return  new Queue("my-queue",true);
    }
}
