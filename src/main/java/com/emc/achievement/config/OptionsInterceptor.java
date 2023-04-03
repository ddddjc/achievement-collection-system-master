package com.emc.achievement.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*@author: yc
*@date: 2020/10/13 下午12:15
*@description: 前端发送options请求的时候不会带上token，
 * 所以要拦截options请求，让前端再发一次真实的请求，并带上token。
*/
@Slf4j
public class OptionsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        addCors(response);
        System.out.println("***"+request.getMethod());
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            response.setStatus(200);
            log.info("拦截 options 请求，请求 URL 为 {}",request.getRequestURL());
            return false;
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
