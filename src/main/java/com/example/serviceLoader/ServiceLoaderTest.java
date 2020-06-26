package com.example.serviceLoader;

import java.util.ServiceLoader;

/**
 * 动态获取接口的实现类
 *
 * @author 18124550
 * @date 2019/7/5
 */
public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<IService> iServices = ServiceLoader.load(IService.class);
        for (IService service: iServices) {
            System.out.println(service.getScheme() + "=" + service.sayHello());
        }
    }
}
