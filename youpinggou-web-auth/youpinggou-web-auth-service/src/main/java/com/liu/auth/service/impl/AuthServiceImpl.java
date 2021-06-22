package com.liu.auth.service.impl;

import com.liu.auth.client.UserClient;
import com.liu.auth.service.IAuthService;
import com.liu.pojo.BaseResult;
import com.liu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 9:04
 */
@Service("authService")
public class AuthServiceImpl implements IAuthService {
    @Autowired
    UserClient userClient;

    @Override
    public User login(User user) {
        BaseResult<User> result = userClient.query(user);
        System.out.println(result.getData());
        user = result.getData();
        return user;
    }
}