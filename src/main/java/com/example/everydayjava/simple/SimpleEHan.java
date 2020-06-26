package com.example.everydayjava.simple;

public class SimpleEHan {
    private SimpleEHan(){};

    private static SimpleEHan simpleEHan;

    public static SimpleEHan getInstance(){
        if (null == simpleEHan){
            synchronized (SimpleEHan.class){
                if (null == simpleEHan){
                    simpleEHan = new SimpleEHan();
                }
            }
        }

        return simpleEHan;
    }
}
