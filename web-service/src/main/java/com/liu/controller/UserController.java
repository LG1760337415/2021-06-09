package com.liu.controller;

import com.liu.entity.BaseResult;
import com.liu.entity.ResultCode;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import com.liu.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
            return new BaseResult(ResultCode.ERROR,"验证码错误");
        }
        userService.saveUser(user);
        return new BaseResult(ResultCode.SUCCESS,"增加成功");
    }
    @PostMapping("/query")
    public BaseResult login(@RequestBody User user){
        System.out.println(user);
        User u = userService.login(user);
        if (u==null){
            u = new User();
            u.setId(-1);
        }
        return new BaseResult<User>(ResultCode.SUCCESS,"查询成功",u);
    }
    @GetMapping("/code")
    public Object getCode(HttpServletResponse response) throws IOException {
        VerificationCode verificationCode = new VerificationCode();
        BufferedImage image = verificationCode.getImage();
        String text = verificationCode.getText();
        redisTemplate.opsForValue().set("USER_CODE",text);
        VerificationCode.output(image,response.getOutputStream());
        return null;
    }
}