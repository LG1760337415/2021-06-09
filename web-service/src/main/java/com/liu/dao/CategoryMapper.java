package com.liu.dao;

import com.liu.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/23 19:15
 */
@Repository
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> findByParentId(Integer parentId);
    List<Category> findAll();
    Category findById(Integer id);
    //查询所以一级分类
    List<Category> findOneStair();

}