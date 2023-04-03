package com.emc.achievement.mapper;

import com.emc.achievement.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKey(User record);

    List<User> find();

    int changePassword(@Param("username") String username, @Param("password") String password);

    int deleteByUsername(@Param("username")String username);


}