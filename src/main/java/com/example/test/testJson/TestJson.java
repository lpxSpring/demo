package com.example.test.testJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 18124550
 * @date 2019/10/25
 */
public class TestJson {

    public static void main(String[] args) {
        // 开发引用默认塞值
        String js = "{\n" +
                "    \"result\":true,\n" +
                "    \"code\":0,\n" +
                "    \"msg\":\"查询成功！\",\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"machineCode\":1,\n" +
                "            \"resConfMenuId\":1,\n" +
                "            \"text\":\"1GPU/8C/50G\",\n" +
                "            \"machineType\":\"1080TI\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"machineCode\":1,\n" +
                "            \"resConfMenuId\":2,\n" +
                "            \"text\":\"2GPU/16C/100G\",\n" +
                "            \"machineType\":\"1080TI\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"machineCode\":1,\n" +
                "            \"resConfMenuId\":7,\n" +
                "            \"text\":\"3GPU/24C/150G\",\n" +
                "            \"machineType\":\"1080TI\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        ResponseStatus rs = JSONObject.parseObject(js, ResponseStatus.class);
//        List<Object> objects = Collections.singletonList(rs.getData());
        JSONArray objects = JSONObject.parseArray(rs.getData().toString());
        for (int i = 0; i < objects.size(); i++) {
            if ("1".equals(objects.getJSONObject(i).getString("resConfMenuId"))) {
                System.out.println(objects.getJSONObject(i));
            }
        }
    }
}
