package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.liu.dao.NewsMapper;
import com.liu.entity.Page;
import com.liu.pojo.News;
import com.liu.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 18:18
 */
@Service("newService")
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsMapper newsMapper;
    @Cacheable(cacheNames = {"news"})
    public List<News> getNewsList(Page page){
        //分页并排序排序
        PageHelper.startPage(page.getPage(),page.getLimit(),page.getSort_by()+" "+page.getSort_way());
        return newsMapper.selectAll();
    }
}
