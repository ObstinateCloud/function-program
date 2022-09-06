package com.lengedyun.func;

import java.util.function.Function;

/**
 * @title: FuncTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/7/29 14:39
 */
public class FuncTest {

    public static void main(String[] args) {

        System.out.println(testFunction(2,i -> i * 2 + 1));
    }

    /**
     *
     * @param i
     * @param function
     * @return
     */
    public static int testFunction(int i, Function<Integer,Integer> function) {

        return function.apply(i);
    }

}
