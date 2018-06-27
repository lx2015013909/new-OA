package com.example.oa.mapper;

import com.example.oa.entity.User;
import com.example.oa.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User,Long> {

    User selectByAll(@Param("username") String username, @Param("password") String password);
    User selectByUsername(String username);
    Integer updateByUsername(@Param("username") String username, @Param("password") String password);
}
