package com.liu.auth.client;

import com.liu.entity.BaseResult;
import com.liu.entity.ResultCode;
import com.liu.pojo.User;

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
