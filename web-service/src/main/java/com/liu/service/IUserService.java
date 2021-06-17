package com.liu.service;

import com.liu.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 10:55
 */
public interface IUserService {
    void saveUser(User user);
    List<User> getUserList();
}
