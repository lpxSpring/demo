package com.example.suppplier;

import java.util.function.Supplier;

/**
 *
 * 貌似这函数的使用相当简单呀，但是简单并非是它的用处少，那它到底可以应用在现实中的什么场合之下呢？工厂就是其一，
 * 因为工厂有时里面是不接收参数的，直接从工厂里面返回一个结果
 *
 *
 * 常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行。
 *
 * @author 18124550
 * @date 2019/7/5
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getName() + ":" + supplier.get().getAge());
    }
}
