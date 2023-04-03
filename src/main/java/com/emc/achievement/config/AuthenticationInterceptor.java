package com.emc.achievement.config;

import com.emc.achievement.exception.UnauthorizedException;
import com.emc.achievement.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
*@author: hxq
*@date: 2020/10/7 下午4:12
*@description: 认证拦截器
*/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        addCors(response);
        String token = request.getHeader("Authorization");
        List<String> adminURI = new ArrayList<>();
        adminURI.add("/user/addUser");
        adminURI.add("/user/list");
        if(token == null){
            throw new UnauthorizedException("未认证，请登录");
        }
        if(JwtUtil.isExpired(token)){
            throw new UnauthorizedException("认证过期，请重新登录");
        }
        if(!JwtUtil.verity(token)){
            throw new UnauthorizedException("认证失败，请重新登录");
        }
        if (adminURI.contains(request.getRequestURI()) && !"ADMIN".equals(JwtUtil.getAuthority(token))){
            throw new UnauthorizedException("权限不够");
        }
        return true;
    }

    private void addCors(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Max-Age", "3600");
    }

}
