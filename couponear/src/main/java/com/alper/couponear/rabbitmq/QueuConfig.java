package com.alper.couponear.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier("simple_queue_config")
public class QueuConfig {

    @Bean(name = "simple_queue")
    public Queue queue(){
        return  new Queue("exam",true);
    }

    @Bean(name = "simple_exchange")
    public DirectExchange direct() {
        return new DirectExchange("exchange.64c102c1-74f9-4ecc-ad2f-6954753b22c2");
    }

    @Bean(name = "simple_binding")
    public Declarables directExchangeBindings(
            DirectExchange directExchange,
            Queue queue) {
        return new Declarables(
                BindingBuilder.bind(queue).to(directExchange).with("64c102c1-74f9-4ecc-ad2f-6954753b22c2"));
    }
}
