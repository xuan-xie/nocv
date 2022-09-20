package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select({"select count(1) from user where id = #{id}"})
    Integer countByUserId(Integer id);

    @Select({"select * from user where id = #{id} and password = #{password}"})
    User selectLoginInfo(@Param("id") Integer id, @Param("password") String password);
}
