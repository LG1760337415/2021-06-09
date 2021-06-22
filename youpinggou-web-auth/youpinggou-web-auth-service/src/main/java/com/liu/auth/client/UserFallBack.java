package com.liu.auth.client;

import com.liu.pojo.BaseResult;
import com.liu.pojo.ResultCode;
import com.liu.pojo.User;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 9:07
 */
public class UserFallBack implements UserClient{
    @Override
    public BaseResult<User> query(User user) {
        user.setId(-1);
        return new BaseResult<User>(ResultCode.ERROR,"查询失败",user);
    }
}
