package com.liu.service;

import com.liu.entity.Page;
import com.liu.pojo.News;

import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 18:18
 */

public interface INewsService {
    public List<News> getNewsList(Page page);
}
