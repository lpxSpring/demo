package com.example.test.jdk8static;

/**
 * @author 18124550
 * @date 2019/7/4
 */
public class Jdk8Static implements IstaticMethodTest{
    public static void main(String[] args) {
        // 接口静态方法只能通过接口名调用
        IstaticMethodTest.hello();
    }
}
