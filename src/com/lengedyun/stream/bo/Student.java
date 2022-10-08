package com.lengedyun.stream.bo;

import java.util.Date;
import java.util.Objects;

/**
 * @title: Student
 * @description: 学生
 * @auther: zhangjianyun
 * @date: 2022/9/20 14:10
 */
public class Student {

    private final String name;

    private final int age;

    private final Date birth;

    private final boolean man;

    public Student(String name, int age, Date birth, boolean man) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.man = man;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public Date getBirth() {
        return birth;
    }

    public boolean isMan() {
        return man;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", man=" + man +
                '}';
    }
}
