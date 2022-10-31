package com.lengedyun.design.factory;



/**
 * @title: Product1
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:41
 */
public class Product1 extends Product {

    String name;

    Integer count;

    Boolean supportCharge;

    public Product1() {
        System.out.println(" p1 no arguments constructor");
    }

    public Product1(String name) {
        this.name = name;
        System.out.println("p1:"+name);
    }

    public Product1(String name,Integer count,Boolean supportCharge){

        this.name = name;
        this.count = count;
        this.supportCharge = supportCharge;
        System.out.println("p1 name:"+name+",count:"+count+",Boolean:"+supportCharge);
    }

    @Override
    public String toString() {
        return "Product1{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", supportCharge=" + supportCharge +
                '}';
    }
}
