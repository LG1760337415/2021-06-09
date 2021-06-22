package com.liu.auth.client;

import com.liu.pojo.BaseResult;
import com.liu.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 9:05
 */
@FeignClient(value = "web-service",fallback = UserFallBack.class)
public interface UserClient {
    @PostMapping("user/query")
    BaseResult<User> query(User user);
}
