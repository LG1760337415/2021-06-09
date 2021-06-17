package com.liu.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/11 10:00
 */
@Component
public class SendSms {
//    @Autowired
//    private RedisT
//    private RedisTemplate redisTemplate;
//    @Autowired
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @RabbitListener(queues = "ypg-sms")
    public void sendSms(String phone){
        String url = "http://45.248.71.53:8080/code/"+phone;

        String code = (String) redisTemplate.opsForValue().get(phone);
        if(code ==null | code==""){
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            code = responseEntity.getBody();
            System.out.printf("手机号码:%s  验证码：%s  \r\n",phone,code);
            redisTemplate.opsForValue().set(phone,code,60, TimeUnit.SECONDS);

        }else {
            System.out.println("验证发已存在，拒接发送");
        }
    }
}