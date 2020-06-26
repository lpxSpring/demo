package com.example.everydayjava.jdk;

/**
 * @author 18124550
 * @date 2019/6/15
 */
public class FinalargsTest {
    public static void main(String[] args) {
        String src = "12";
        testArgs(src);
        System.out.println(src="45");


    }

    private static void testArgs(final String src) {
//        src = "change it";  不允許修改src
        System.out.println(src);
    }
}
