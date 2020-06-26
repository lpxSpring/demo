package com.example.test.typesafeconfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author 18124550
 * @date 2019/7/17
 */
public class TypesafeConfigTest {
    public static void main(String[] args) {
        // 默认加载resources下的application.*和reference.ref
        Config config = ConfigFactory.load();
        String str = config.getString("lpx");
        System.out.println(str);
        Config config1 = config.getObject("application1").toConfig();
        System.out.println(config1.getString("name1"));

        // 可以指定加载文件
        Config config2 = ConfigFactory.load("conf/system.conf");
        Config toConfig = config2.getObject("application1").toConfig();
        System.out.println(toConfig.getString("name1"));
    }

}
