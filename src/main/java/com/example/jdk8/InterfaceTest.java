package com.example.jdk8;

/**
 * @author 18124550
 * @date 2019/10/25
 */
public interface InterfaceTest {
    void eat();

    default void drink(){
        System.out.println("drink wanter..");
    }

    static void wan(){
        System.out.println("drink wan..");
    }
}
