package com.example.futuretask;

import java.util.concurrent.*;

/**
 * 一个可取消的异步计算
 * 该类提供了Future的基本实现，提供了启动和取消计算、查询计算是否完成以及检索计算结果的方法
 * 只有在计算完成后才可检索结果；如果计算尚未完成，get方法将阻塞
 * 计算完成以后，计算不能重启或取消（除非调用runAndReset方法）
 * 一个FutureTask可以用来包装一个Callable或Runnable对象。因为FutureTask实现了Runnable接口，一个FutureTask可以被提交给一个Executor来执行。
 *
 * 在实际开发过程中，将那些耗时较长，且可以并行的操作都封装成一个FutureTask（比如：有的数据通过调用dubbo服务获取，有的数据需要从缓存中读取，有的数据需要复杂的计算）在实际开发过程中，将那些耗时较长，
 * 且可以并行的操作都封装成一个FutureTask（比如：有的数据通过调用dubbo服务获取，有的数据需要从缓存中读取，有的数据需要复杂的计算）
 *
 * @author 18124550
 * @date 2019/8/2
 */
public class FutureTaskTest {
    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        FutureTask<String> heatUpFuture = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("烧开水...");
                Thread.sleep(3000);
                return "ok";
            }
        });

        FutureTask<String> cookMealsFuture = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("煮饭...");
                Thread.sleep(5000);
                return "ok";
            }
        });

        executorService.submit(heatUpFuture);
        executorService.submit(cookMealsFuture);

        System.out.println("炒菜...");
        Thread.sleep(2000);
        System.out.println("菜炒好了了");

        if (heatUpFuture.get(5000, TimeUnit.SECONDS) == "ok"
                && cookMealsFuture.get(5000, TimeUnit.SECONDS) == "ok") {
            System.out.println("开饭了...");
        }

        System.out.println("做饭用时：" + (System.currentTimeMillis() - t1) + "ms");
    }
}
