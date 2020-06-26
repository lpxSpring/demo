package com.example.test.kaoshi;

/**
 * @author 18124550
 * @date 2019/2/18
 */
class B extends A{
    private static final Long aaa = 0L;
    public int getNumber(int a, char c){
        return a+2;
    }
    public static void main(String[] args){
        B b=new B();
        System.out.println(b.getNumber(0));

        System.out.printf("" + aaa.equals(0L));
    }
}

