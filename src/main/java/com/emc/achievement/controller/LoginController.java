package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.User;
import com.emc.achievement.mapper.UserMapper;
import com.emc.achievement.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Api(tags = "登录")
@RestController
public class LoginController {

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "登录",notes = "登录时返回token，之后所有请求都在请求头中加入Authorization")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map<String,String> map) {
        HashMap<String,Object> result = new HashMap<>();
        User user = userMapper.selectByPrimaryKey(map.get("username"));
        log.info("====== 登录 ======"+user);
        if(user == null){
            return ResponseResult.ofFail("用户不存在");
        }
        if(!user.getPassword().equals(map.get("password"))){
            return ResponseResult.ofFail("密码错误");
        }
        String token = JwtUtil.createToken(user.getUsername(),user.getAuthority());
        result.put("token", token);
        user.setPassword(null);
        result.put("user", user);
        return ResponseResult.ofSuccess("登录成功", result);
    }

}
