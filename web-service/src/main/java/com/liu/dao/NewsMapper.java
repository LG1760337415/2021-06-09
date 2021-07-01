package com.liu.dao;

import com.liu.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 18:26
 */
@Repository
@Mapper
public interface NewsMapper  extends BaseMapper<News> {

}
