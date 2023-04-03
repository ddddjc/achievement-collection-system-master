package com.emc.achievement.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.emc.achievement.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
*@author: hxq
*@date: 2020/10/7 下午2:45
*@description: 全局异常处理
*/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {


    /**
    *@author: hxq
    *@date: 2020/10/7 下午2:46
    *@description: 登录认证时抛出异常，给前端返回信息
     * todo UnauthorizedException.class
    */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseResult handlerUnauthorizedException(UnauthorizedException e, HttpServletRequest request){
        log.error("uri:"+request.getRequestURI()+"                             message:"+e.getMessage());
        return ResponseResult.ofFail(e.getMessage());
    }

    /**
    *@author: hxq
    *@date: 2020/10/7 下午2:47
    *@description: 处理token验证失败异常，返回前端信息
    */
    @ExceptionHandler(JWTVerificationException.class)
    public ResponseResult handlerJWTVerificationException(JWTVerificationException e){
        log.error("token校验失败，已被拦截");
        return ResponseResult.ofFail("无效token，请重新登录");
    }

    @ExceptionHandler(BindException.class)
    public ResponseResult handlerBindException(BindException e){
        log.error("数据校验");
        List<FieldError> fieldErrors = e.getFieldErrors();
        HashMap<String,String> map = new HashMap<>();
        for(FieldError fieldError : fieldErrors){
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseResult.ofFail(map);

    }
}
