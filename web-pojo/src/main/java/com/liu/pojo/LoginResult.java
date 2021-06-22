package com.liu.pojo;

import lombok.Data;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 11:01
 */
@Data
public class LoginResult extends BaseResult{
    private String name;
    private String token;

    public LoginResult(Integer error, String errmsg, String name, String token) {
        super(error, errmsg);
        this.name = name;
        this.token = token;
    }
}
