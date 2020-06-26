package com.example.jdk8;


import java.util.List;

/**
 * @author 18124550
 * @date 2019/10/25
 */
public class InterfaceImpl implements InterfaceTest{
    @Override
    public void eat() {
        System.out.println("eat pig...");
    }

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceImpl();
        interfaceTest.eat();
        interfaceTest.drink();
        InterfaceTest.wan();
    }
}
