package com.liu.entity;

import lombok.Data;

import java.util.Collection;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/28 9:02
 */
@Data
public class Page<T> {
    private Integer limit;//条数
    private Integer page;//页码
    private Integer offset;//起始索引
    private Integer per_page;//每页条数
    private String sort_by;//排序字段
    private String sort_way;//排序方式

    private Collection<T> data;//数据

}
