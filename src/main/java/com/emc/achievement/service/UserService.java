package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.User;

public interface UserService {

    ResponseResult findByName(String username);

    ResponseResult userList();

    ResponseResult updateUser(User user);

    ResponseResult createUser(User user);

    ResponseResult changePassword(String username, String password);

    ResponseResult deleteByUsername(String username);


}


