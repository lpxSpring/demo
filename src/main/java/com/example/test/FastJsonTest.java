package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.test.testJson.ResponseStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 18124550
 * @date 2019/12/4
 */
public class FastJsonTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fasrJson", new ResponseStatus());
        jsonObject.put("fasrJson", new ResponseStatus(false, 0, "hello"));

        System.out.println(new ResponseStatus(true, "success", jsonObject));
    }
}
