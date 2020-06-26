package com.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 18124550
 * @date 2019/9/27
 */
public class DeadLockClass {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "得到Lock1");
                    Thread.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "得到Lock2");
                }
            }
        }, "线程1").start();

        new Thread(() ->{
            synchronized (lock2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "得到Lock2");
                    Thread.sleep(3000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "得到Lock1");
                }
            }
        }, "线程2").start();
    }

}
