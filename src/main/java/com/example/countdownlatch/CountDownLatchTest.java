package com.example.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author 18124550
 * @date 2019/1/7
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        testCountDownLatch();
    }

    public static void testCountDownLatch(){
        int threadCount = 10;
        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i=0; i<threadCount; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getId() + "开始出发");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println("线程" + Thread.currentThread().getId() + "到达终点");

                    latch.countDown();// 不加这行代码，主线程会暂停等待
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("10个线程已经执行完毕！开始计算排名");
    }
}
