package com.example.everydayjava.simple;

public class SimpleLanHan {
    private SimpleLanHan(){};

    private static SimpleLanHan simpleLanHan = new SimpleLanHan();

    public static SimpleLanHan getInstance(){
        return simpleLanHan;
    }

}
