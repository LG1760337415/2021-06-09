package com.liu.service.impl;

import com.liu.dao.CategoryMapper;
import com.liu.pojo.Category;
import com.liu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/23 19:21
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Cacheable(cacheNames = {"category"})
    @Override
    public List<Category> findOneStair() {
        return categoryMapper.findOneStair();
    }
}