package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 18124550
 * @date 2019/7/22
 */
public class ThreadTest {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        new Thread1().start();
        new Thread(new Thread2()).start();

        getExecutorService().execute(new Thread2());
        getExecutorService().execute(new Thread1());
    }

    public static ExecutorService getExecutorService() {
        if (null ==  executorService) {
            synchronized (ThreadTest.class) {
                if (null == executorService) {
                    return  new ThreadPoolExecutor(5, 50, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
                } else {
                    return executorService;
                }
            }
        } else {
            return executorService;
        }
    }
}
