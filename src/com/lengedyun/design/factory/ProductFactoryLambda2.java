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
public class ProductFactoryLambda2 {

    public static Product createProduct(String name,Integer count,Boolean supportCharge) {
        MultiParamProduct<String, Integer, Boolean, Product> productSupplier = map.get(name);
        if (productSupplier != null) {
            return productSupplier.apply(name,count,supportCharge);
        } else {

            throw new IllegalArgumentException("No such product " + name);
        }
    }

    static Map<String, MultiParamProduct<String,Integer,Boolean,Product>> map = new HashMap<>();

    static {
        map.put("p1", Product1::new);
        map.put("p2", Product2::new);
    }

}
