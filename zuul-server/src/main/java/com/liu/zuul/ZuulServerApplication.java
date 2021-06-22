package com.liu.zuul;

import com.liu.auth.conf.JwtProperties;
import com.liu.zuul.filter.JWTJurisdiction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 9:26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class,args);
    }
    @Bean
    public JWTJurisdiction createJWTJurisdiction(){
        return new JWTJurisdiction();
    }
    @Bean
    public JwtProperties createJwtProperties(){
        return new JwtProperties();
    }
}
