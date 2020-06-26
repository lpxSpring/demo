package com.example.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 18124550
 * @date 2019/6/25
 */
public class UserAtomic {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new AtomicTest(atomicInteger));
            t.start();
            try {
                t.join(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.get());
        }
    }
}


class AtomicTest implements Runnable {
    AtomicInteger atomicInteger;

    public AtomicTest(AtomicInteger atomicInteger){
        this.atomicInteger=atomicInteger;
    }
    @Override
    public void run() {
        atomicInteger.addAndGet(1);
        atomicInteger.addAndGet(2);
        atomicInteger.addAndGet(3);
        atomicInteger.addAndGet(4);
    }

}