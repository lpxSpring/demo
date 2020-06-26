package com.example.test.ioc.dao;

import com.example.test.ioc.bean.User;

/**
 * TODO DAO层
 *
 * @author 18124550
 * @date 2019/1/8
 */
public interface UserDao {
    void save(User u);
    void delete();
}
