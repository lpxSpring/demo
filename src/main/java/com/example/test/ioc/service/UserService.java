package com.example.test.ioc.service;

import com.example.test.ioc.bean.User;
import com.example.test.ioc.dao.UserDao;

/**
 * TODO
 *
 * @author 18124550
 * @date 2019/1/8
 */
public class UserService {
    private UserDao userDao;

    public void addUser(User u) {
        this.userDao.save(u);
    }

    /**
     *
     * @return
     */
    public UserDao getUserDao() {
        return this.userDao;
    }

    /**
     *
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
