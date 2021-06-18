package com.liu.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/17 18:36
 */
@Data
public class JWTResult extends BaseResult{
    private String id;
    private String token;
    private Timestamp netTime;

    public JWTResult(Integer error, String errmsg, String id, String token, Timestamp netTime) {
        super(error, errmsg);
        this.id = id;
        this.token = token;
        this.netTime = netTime;
    }
}
