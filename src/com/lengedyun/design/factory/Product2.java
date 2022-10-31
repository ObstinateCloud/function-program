package com.lengedyun.design.factory;

/**
 * @title: Product1
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:41
 */
public class Product2 extends Product {

    String name;

    Integer count;

    Boolean supportCharge;

    public Product2() {
        System.out.println(" p2 no arguments constructor");
    }

    public Product2(String name) {
        this.name = name;
        System.out.println("p2:"+name);
    }

    public Product2(String name,Integer count,Boolean supportCharge){
        this.name = name;
        this.count = count;
        this.supportCharge = supportCharge;
        System.out.println("p2 name:"+name+",count:"+count+",Boolean:"+supportCharge);
    }

    @Override
    public String toString() {
        return "Product2{" +
                "name='" + name + '\'' +
                ", num=" + count +
                ", supportCharge=" + supportCharge +
                '}';
    }
}
