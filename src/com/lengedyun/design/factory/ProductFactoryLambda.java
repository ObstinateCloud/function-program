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
public class ProductFactoryLambda {

    public static Product createProduct(String name) {
        Supplier<Product> productSupplier = map.get(name);
        if (productSupplier != null) {
            return productSupplier.get();
        } else {

            throw new IllegalArgumentException("No such product " + name);
        }
    }

    static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("p1", Product1::new);
        map.put("p2", Product2::new);
    }

}
