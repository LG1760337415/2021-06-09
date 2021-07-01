package com.liu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 10:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T>  implements Serializable {
    private Integer error;
    private String errmsg;
    private T data;

    public BaseResult(Integer error, String errmsg) {
        this.error = error;
        this.errmsg = errmsg;
    }
}
