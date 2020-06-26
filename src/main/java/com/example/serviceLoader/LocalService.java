package com.example.serviceLoader;

/**
 * @author 18124550
 * @date 2019/7/5
 */
public class LocalService implements IService {
    @Override
    public String sayHello() {
        return "Hello LocalService";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}
