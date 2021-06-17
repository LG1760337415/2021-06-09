package com.liu.sms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/11 9:06
 */
@Configuration
public class MQConfig {
    @Bean
    public Queue query(){
        return new Queue("ypg-sms",true);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("ypg-directExchange",true,false);
    }

//    @Bean
//    public RabbitTemplate createRabbitTemplate(){
//        return new  RabbitTemplate();
//    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(query()).to(directExchange()).with("sms");
    }

}
