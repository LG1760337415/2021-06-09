package com.liu.controller;

import com.liu.pojo.BaseResult;
import com.liu.pojo.ResultCode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/11 9:16
 */
@RestController
public class SmsController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sms/{phone}")
    public BaseResult sendSms(@PathVariable String phone){

        rabbitTemplate.convertAndSend("ypg-directExchange","sms",phone);
        return new BaseResult(ResultCode.SUCCESS,"发送成功");
    }
}