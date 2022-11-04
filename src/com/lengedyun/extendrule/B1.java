package com.lengedyun.extendrule;

/**
 * @title: B1
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 14:52
 */
public interface B1 {
    default void sayHello() {
        System.out.println("Hello from B1");
    }
}
