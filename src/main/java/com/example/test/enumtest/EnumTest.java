package com.example.test.enumtest;

/**
 * @author 18124550
 * @date 2019/7/22
 */
public class EnumTest {
    public enum E {one, TWO, THREE}

    public static void main(String[] args) {
        System.out.println(E.one);
        System.out.println(E.TWO);
        System.out.println(E.THREE);
    }
}
