package com.liu.auth.controller;

import com.liu.auth.conf.JwtProperties;
import com.liu.auth.pojo.UserInfo;
import com.liu.auth.service.IAuthService;
import com.liu.auth.util.JwtUtils;
import com.liu.pojo.BaseResult;
import com.liu.pojo.LoginResult;
import com.liu.pojo.ResultCode;
import com.liu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 8:59
 */
@RestController
public class AuthController {
    @Autowired
    IAuthService authService;
    @Autowired
    JwtProperties jwtProperties;
    @PostMapping("/login")
    public BaseResult login(@RequestBody User user) throws Exception {
        User u = authService.login(user);
        if (u==null||u.getId()==-1){
            return new BaseResult(ResultCode.USER_NOT_FOUND,"用户未找到");
        }
        UserInfo info = new UserInfo(u.getId(),u.getName());
        String token = JwtUtils.generateToken(info, jwtProperties.getPrivateKey(), 30);
        return new LoginResult(ResultCode.SUCCESS,"查询成功",u.getName(),token) ;
    }
}