package com.liu.service.impl;

import com.liu.dao.UserMapper;
import com.liu.pojo.User;
import com.liu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 10:56
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void saveUser(User user) {
        Timestamp createTime = new Timestamp(new Date().getTime());
        user.setCreatedAt(createTime);
        user.setUpdatedAt(createTime);
        user.setExpriece(0);
        userMapper.insert(user);
    }

    public List<User> getUserList(){
        return userMapper.selectAll();
    }
}