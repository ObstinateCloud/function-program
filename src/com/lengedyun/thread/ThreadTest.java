package com.lengedyun.thread;

import java.util.function.IntBinaryOperator;

public class ThreadTest {


    public static void main(String[] args) {
        //常规写法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("常规写法启动子线程");
//            }
//        }).start();
//
//        // lambda 写法
//        new Thread(()->{
//            System.out.println("lambda 方式启动子线程");
//        }).start();

        //常规写法
        int res = calcNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        System.out.println(res);

        int res2 = calcNum((left, right) -> {
            return left+right;
        });
        System.out.println(res2);
    }
    //内置函数式接口
    public static int calcNum(IntBinaryOperator intBinaryOperator){
        int left = 10;
        int right = 20;
        return intBinaryOperator.applyAsInt(left, right);
    }
}
