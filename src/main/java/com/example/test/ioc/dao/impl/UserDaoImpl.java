package com.example.test.ioc.dao.impl;

import com.example.test.ioc.bean.User;
import com.example.test.ioc.dao.UserDao;

/**
 * TODO
 *
 * @author 18124550
 * @date 2019/1/8
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User u) {
        System.out.println("User:" + u.toString());
    }

    @Override
    public void delete() {
        System.out.println("delete User");
    }
}
