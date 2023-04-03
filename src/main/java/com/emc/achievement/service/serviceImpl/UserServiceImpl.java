package com.emc.achievement.service.serviceImpl;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.User;
import com.emc.achievement.mapper.UserMapper;
import com.emc.achievement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseResult findByName(String username) {
        log.info("======= 查找用户 =======" + username);
        User user = userMapper.selectByPrimaryKey(username);
        if (user == null) {
            log.info("======= 用户不存在 =======" + username);
            return ResponseResult.ofFail("用户不存在");
        }
        user.setPassword(null);
        log.info("======= 查找用户成功 =======" + username);
        return ResponseResult.ofSuccess("查询用户成功", user);
    }

    @Override
    public ResponseResult userList() {
        log.info("查询用户列表");
        List<User> users = userMapper.find();
        for (int i=0;i<users.size();i++){
            if(null==users.get(i).getUsername()||users.get(i).getUsername().equals(null)){
                users.remove(users.get(i));
            }
        }
//        return ResponseResult.ofSuccess("用户列表查询成功", userMapper.find());
        return ResponseResult.ofSuccess("用户列表查询成功", users);
    }

    @Override
    public ResponseResult updateUser(User user) {
        log.info("更新用户" + user);
        if (userMapper.updateByPrimaryKey(user) == 0) {
            log.warn("更新用户失败");
            return ResponseResult.ofFail("更新用户失败");
        }
        log.info("更新用户成功");
        return ResponseResult.ofSuccess("更新用户成功");
    }

    @Override
    public ResponseResult createUser(User user) {
        log.info("新建用户");
        if (userMapper.selectByPrimaryKey(user.getUsername()) != null) {
            return ResponseResult.ofFail("用户已存在");
        }
        if (userMapper.insert(user) == 0) {
            return ResponseResult.ofFail("用户创建失败");
        }
        return ResponseResult.ofSuccess("新增用户成功");
    }

    @Override
    public ResponseResult changePassword(String username, String password) {
        log.info("更新用户密码" + username);
        if (userMapper.changePassword(username, password) == 1) {
            return ResponseResult.ofSuccess("重置密码成功");
        }
        return ResponseResult.ofFail("重置密码失败");
    }

    @Override
    public ResponseResult deleteByUsername(String username) {
        if(userMapper.deleteByUsername(username) == 1){
            log.info("删除用户{}成功",username);
            return ResponseResult.ofSuccess("删除用户成功");
        }
        log.info("删除{}用户失败",username);
        return ResponseResult.ofFail("删除用户失败");
    }

}


