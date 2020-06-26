package com.example.test.exceptionhandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/testException")
public class BaseExceptionHandlerTest extends BaseExceptionHandler{

    @RequestMapping("doTest")
    public Map<String, String> testException(){
        Map<String, String> resMap = new HashMap<String, String>();
        resMap.put("操作结果：", "contoller...");
        String s = null;
        s.length();
        return resMap;
    }
}
