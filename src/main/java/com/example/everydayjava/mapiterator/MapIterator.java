package com.example.everydayjava.mapiterator;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {

    // 1.
    public static void mapIterator1(Map<String, String> strMap){
        System.out.println("-------1----------");

        if (CollectionUtils.isEmpty(strMap)){
            return;
        }
        for (Map.Entry<String, String> entry : strMap.entrySet()){
            System.out.println(entry.getKey() + ":" +entry.getValue());
        }

    }

    // 2.
    public static void mapIterator2(Map<String, String> strMap)
    {
        System.out.println("-------2----------");

        if (CollectionUtils.isEmpty(strMap)){
            return;
        }
        for (String key : strMap.keySet()){
            System.out.println(key + ":" + strMap.get(key));
        }

    }

    // 3.
    public static void mapIterator3(Map<String, String> strMap){
        System.out.println("-------3----------");

        if (CollectionUtils.isEmpty(strMap)){
            return;
        }

        Iterator<Map.Entry<String, String>> iterator = strMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    public static void main(String[] args) {
        Map<String, String> strMap = new HashMap<String, String>();
        strMap.put("name", "lpx");
        strMap.put("age", "18");
        strMap.put("like", "code");

        mapIterator3(strMap);

        mapIterator1(strMap);

        mapIterator2(strMap);


    }
}
