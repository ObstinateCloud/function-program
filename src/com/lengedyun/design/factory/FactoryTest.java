package com.lengedyun.design.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @title: FactoryTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:38
 */
public class FactoryTest {

    public static void main(String[] args) {
        System.out.println(ProductFactory.createProduct("p1"));
        System.out.println(ProductFactory.createProduct("p2"));

        System.out.println(ProductFactoryLambda.createProduct("p1"));
        System.out.println(ProductFactoryLambda.createProduct("p2"));

        System.out.println(ProductFactoryLambda2.createProduct("p1", 2, false));
        System.out.println(ProductFactoryLambda2.createProduct("p2", 3, true));
    }



}
