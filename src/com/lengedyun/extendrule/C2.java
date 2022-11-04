package com.lengedyun.extendrule;

/**
 * @title: C2
 * @description: 接口可以多继承
 * @auther: zhangjianyun
 * @date: 2022/11/4 15:04
 */
public interface C2 extends A1,B1 {


    @Override
    default void sayHello() {
        System.out.println("Hello from C2");
    }
}
