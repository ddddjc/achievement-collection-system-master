package com.emc.achievement.entity;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {

    private int status;

    private T data;

    private String message;

    public static ResponseResult ofSuccess(String message){
        ResponseResult result = new ResponseResult();
        result.setStatus(1);
        result.setMessage(message);
        return result;
    }

    public static ResponseResult ofSuccess(String message,Object data){
        ResponseResult result = new ResponseResult();
        result.setStatus(1);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static ResponseResult ofFail(String message){
        ResponseResult result = new ResponseResult();
        result.setStatus(0);
        result.setMessage(message);
        return result;
    }
    public static ResponseResult ofFail(Object data){
        ResponseResult result = new ResponseResult();
        result.setStatus(0);
        result.setData(data);
        return result;
    }
}
