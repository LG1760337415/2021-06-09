package com.liu;

import com.liu.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sound.midi.Soundbank;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/16 17:04
 */
@SpringBootTest
public class ServiceApplicationTest {


    @Autowired
    private IUserService userService;
    @Test
    public void test(){
        System.out.println(userService.getUserList());
    }
}