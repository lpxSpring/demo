package com.example.test.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Map<String, String> exceptionHandler(Exception e){
        Map<String, String> resMap = new HashMap<String, String>();
        resMap.put("操作异常：", e.getMessage());
        System.out.println("操作异常：" + e.getMessage());
        return resMap;
    }
}
