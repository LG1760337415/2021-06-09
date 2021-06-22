package com.liu.auth.service;

import com.liu.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 9:02
 */
@Service
public interface IAuthService {
    public User login(User user);
}
