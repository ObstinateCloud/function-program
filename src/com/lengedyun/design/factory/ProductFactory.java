package com.lengedyun.design.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @title: ProductFactory
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:39
 */
public class ProductFactory {


    public static Product createProduct(String name){

        if(name.equals("p1")){
            return new Product1(name);
        }
        if(name.equals("p2")){
            return new Product2(name);
        }

        return null;
    }



}
