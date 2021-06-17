package com.liu.dao;

import com.liu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
