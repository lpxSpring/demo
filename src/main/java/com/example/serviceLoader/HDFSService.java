package com.example.serviceLoader;

/**
 * @author 18124550
 * @date 2019/7/5
 */
public class HDFSService implements IService {
    @Override
    public String sayHello() {
        return "Hello HDFSService";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}
