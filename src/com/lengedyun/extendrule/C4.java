package com.lengedyun.extendrule;

/**
 * @title: C3
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 16:12
 */
public interface C4 extends A1 {

    @Override
    default void sayHello() {
        System.out.println("hello from c4");
    }
}
