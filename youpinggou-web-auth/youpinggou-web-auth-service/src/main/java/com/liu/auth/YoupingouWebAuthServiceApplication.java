package com.liu.auth;

import com.liu.auth.conf.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.core.RedisTemplate;
//
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class YoupingouWebAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoupingouWebAuthServiceApplication.class, args);
    }
    @Bean
    public JwtProperties createJwtProperties(){
        return new JwtProperties();
    }
}