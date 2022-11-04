package com.lengedyun.extendrule;

/**
 * @title: C1
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 14:52
 */
public class C1 implements A1,B1{


    @Override
    public void sayHello() {
        A1.super.sayHello();
        B1.super.sayHello();
        System.out.println("Hello from C1");
    }
}
