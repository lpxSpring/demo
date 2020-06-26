package com.example.test.ioc;

import com.example.test.ioc.bean.User;
import com.example.test.ioc.service.UserService;

/**
 * TODO 测试IoC
 *
 * @author 18124550
 * @date 2019/1/8
 */
public class RunIoc {
    public static void main(String[] args) throws Exception {
        BeanFactory factory = new ClassPathXmlApplicationContext();
        // 通过工厂直接获取
        UserService userService = (UserService) factory.getBean("userService");
        // 其实User也可以从工厂中获得
        User u = (User) factory.getBean("user");
        // User u = new User();
        u.setUserName("tom");
        u.setPassword("123456");
        userService.addUser(u);//打印结果tom123456
    }
}
