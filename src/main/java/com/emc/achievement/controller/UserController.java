package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.User;
import com.emc.achievement.service.UserService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @ApiOperation("查询老师列表")
    @GetMapping("/list")
    ResponseResult uerList(){
        log.info("到达:user/list");
        return userService.userList();
    }

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    ResponseResult createUser(@RequestBody User user){
        user.setPassword("21218cca77804d2ba1922c33e0151105");
        user.setFullInformation(false);
        user.setEnabled(true);
        user.setAuthority("USER");
        return userService.createUser(user);
    }
    public static Date set(Date date){
        // 获取当前时间
        Date d = date;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE, 1);
        // 这个时间就是日期往后推一天的结果
        d = calendar.getTime();
        return d;
    }
    @ApiOperation("更新用户信息")
    @PostMapping("/updateUser/pu")
    ResponseResult updateUser(@RequestBody @Validated User user){
        log.info("到达:user/update");
        user.setComeTime(DataLat.set(user.getComeTime()));
        user.setTeachingTime(DataLat.set(user.getTeachingTime()));
        user.setBornAt(DataLat.set(user.getBornAt()));
        return userService.updateUser(user);
    }

    @ApiOperation("通过老师工号查询")
    @PostMapping("/findUser")
    ResponseResult findByUserName(String username){
        return userService.findByName(username);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "username",value = "username")
    @PostMapping("/deleteUser/del")
    ResponseResult delete(@RequestBody HashMap<String,String> username){
        log.info("到达:user/del");
        return userService.deleteByUsername(username.get("username"));
    }

    @ApiOperation("改变用户密码")
    @PostMapping("/changePassword")
    ResponseResult changePassword(@RequestBody Map<String,String> map){
        log.info("更改用户密码"+map.get("username"));
        String password = map.get("password");
        String username = map.get("username");
        if (password == null){
            password = "21218cca77804d2ba1922c33e0151105";
        }
        return userService.changePassword(username, password);
    }

}
