package com.example.jdk8;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 18124550
 * @date 2019/8/27
 */
public class ListTest {
    public static void main(String[] args) {
        System.out.println(Lists.newArrayList("huahua", "zhuzhu"));

        Set<String> set = Sets.newHashSet();
        set.add("11");
        set.add("22");
        set.add("33");
        System.out.println(set.stream().limit(2).collect(Collectors.toList()));

        List<String> list = Lists.newArrayList("1", "2", "3");
        list.forEach(li -> {
            if ("1".equals(li)) {
                System.out.println("有1的值。。");
            }
        });

        System.out.println(list);

        List<String> listNew = list.stream().map(li -> {
            if ("1".equals(li)) {
                System.out.println("有1的值");
                return "4";
            } else {
                return li;
            }

        }).collect(Collectors.toList());

        System.out.println(listNew);

    }
}
