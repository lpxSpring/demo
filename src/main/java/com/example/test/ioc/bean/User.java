package com.example.test.ioc.bean;

/**
 * TODO  User实体类
 *
 * @author 18124550
 * @date 2019/1/8
 */
public class User {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.userName).append(":");
        sb.append(this.password);
        return sb.toString();
    }
}
