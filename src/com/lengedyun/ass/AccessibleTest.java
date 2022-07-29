package com.lengedyun.ass;

import java.lang.reflect.Field;

/**
 * @title: AccessibleTest
 * @description: 反射赋值私有变量
 * @auther: 张健云
 * @date: 2021/4/21 19:42
 */
public class AccessibleTest {

    protected int id;
    protected String name;

    public AccessibleTest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // write your code here
        Class clazz = null;
        try {
            clazz = Class.forName("com.lengedyun.ass.AccessibleTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        AccessibleTest at = new AccessibleTest();
        at.setId(1);
        at.setName("AT");
        for (Field f : clazz.getDeclaredFields()) {
            //f.setAccessible(true);//AccessibleTest类中的成员变量为private,故必须进行此操作
            try {
                System.out.println(f.get(at));//获取当前对象中当前Field的value
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

}
