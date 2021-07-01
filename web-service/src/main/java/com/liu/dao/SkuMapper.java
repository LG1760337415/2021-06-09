package com.liu.dao;

import com.liu.pojo.News;
import com.liu.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Repository
public interface SkuMapper extends BaseMapper<Sku> {
    @Select("select * from tb_sku where id = #{id}")
    Sku findById(Integer id);
}
