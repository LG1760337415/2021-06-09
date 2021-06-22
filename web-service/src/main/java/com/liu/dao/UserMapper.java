package com.liu.dao;

import com.liu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select(value = "select * from tb_user where mobile = #{mobile} and password = #{password} ")
    User login(User user);
}
