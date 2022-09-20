package com.lengedyun.lambda;

import java.util.function.Function;

/**
 * @title: LambdaTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/16 9:11
 */
public class LambdaTest {


    public static void main(String[] args) {
        //传参1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("方式1");
            }
        };
        process(runnable);
        //传参2
        Runnable runnable1 = ()-> System.out.println("传参2");
        process(runnable1);
        //传参3
        process(()-> System.out.println("传参3"));


    }

    //参数需要一个runnable 对象
    private static void process(Runnable runnable){

        runnable.run();
    }

}
