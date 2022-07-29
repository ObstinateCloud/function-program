package com.lengedyun;

import com.lengedyun.ass.AccessibleTest;

import java.lang.reflect.Field;

public class Main {

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
