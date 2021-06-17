package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 10:44
 */
@RestController
public class TestController {
    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/api/wechat")
    public String wechat(){
        System.out.println("hello world");
        return "hello";
    }
}
