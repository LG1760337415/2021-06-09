package com.liu.controller;

import com.liu.pojo.BaseResult;
import com.liu.pojo.JWTResult;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 10:59
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IUserService userService;
    @PostMapping("/regist")
    public BaseResult regist(@RequestBody User user){
        System.out.println(user);
        String code = redisTemplate.opsForValue().get(user.getMobile());
        System.out.println(code);
        if (!user.getCode().equalsIgnoreCase(code)){
            return new BaseResult(50001,"验证码错误");
        }
        userService.saveUser(user);
        return new BaseResult(200,"增加成功");
    }
    @PostMapping("/login")
    public JWTResult login(@RequestBody User user){
        System.out.println(user);
        userService.login(user);
        long time = 2222;
        return new JWTResult(200,"登录成功","12","DFASDFA",new Timestamp(222));
    }
}