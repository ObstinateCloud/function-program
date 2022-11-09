package com.lengedyun.completableFuture.betterbuy;

/**
 * @title: Quote
 * @description: 报价对象
 * @auther: zhangjianyun
 * @date: 2022/11/9 14:39
 */
public class Quote {

    private String shopName;

    private double price;

    private DiscountServcie.Code discountCode;

    public Quote(String shopName, double price, DiscountServcie.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    //将结果转换为对象
    public static Quote parse(String str){
        String[] split = str.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        DiscountServcie.Code disCountCode = DiscountServcie.Code.valueOf(split[2]);
        return new Quote(shopName,price,disCountCode);

    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public DiscountServcie.Code getDiscountCode() {
        return discountCode;
    }
}
