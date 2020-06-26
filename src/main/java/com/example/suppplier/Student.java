package com.example.suppplier;

/**
 * @author 18124550
 * @date 2019/7/5
 */
public class Student {

    private String name = "lpx";

    private String age = "30";

    public Student(){}

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
