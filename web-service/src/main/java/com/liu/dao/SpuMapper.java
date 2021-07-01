package com.liu.dao;

import com.liu.pojo.Spu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Repository
public interface SpuMapper extends BaseMapper<Spu> {
    Spu findById(Integer id);
}
