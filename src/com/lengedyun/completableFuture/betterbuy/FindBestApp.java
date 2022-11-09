package com.lengedyun.completableFuture.betterbuy;

import java.util.Arrays;
import java.util.List;

/**
 * @title: FindBestApp
 * @description: 查找最优价格的应用
 * @auther: zhangjianyun
 * @date: 2022/11/9 13:58
 */
public class FindBestApp {

    public static void main(String[] args) {
        //1.商铺初始化
        List<Shop> shops = getShopList();
        //2.从多个商店中查询同一商品价格
//        PriceService priceService = new PriceService(shops);
//        List<String> iphone1 = priceService.findPrices("iphone14ProMax");
//        System.out.println(iphone1);
//        List<String> iphone2 = priceService.findPricesParallel("iphone14ProMax");
//        System.out.println(iphone2);
//        List<String> iphone3 = priceService.findPricesAsync("iphone14ProMax");
//        System.out.println(iphone3);
//        List<String> iphone4 = priceService.findPricesAsyncCusExecutor("iphone14ProMax");
//        System.out.println(iphone4);
        //3.从多个商店中查询同一商品折扣后价格
        DiscountServcie discountServcie = new DiscountServcie(shops);
//        List<String> iphone14ProMax1 = discountServcie.findDiscountPrice("iphone14ProMax");
//        System.out.println(iphone14ProMax1);
//
//        List<String> iphone14ProMax2 = discountServcie.findDiscountPriceAsync("iphone14ProMax");
//        System.out.println(iphone14ProMax2);

        discountServcie.findDiscountPriceAsyncStream("iphone14ProMax");


    }


    private static List<Shop> getShopList(){

         return Arrays.asList(
                new Shop("shopA"),
                new Shop("shopB"),
                new Shop("shopC"),
                new Shop("shopD"),
                new Shop("shopE"),
                new Shop("shopF"),
                new Shop("shopG"),
                new Shop("shopH"),
                new Shop("shopI"),
                new Shop("shopJ"),
                new Shop("shopK"),
                new Shop("shopL"),
                new Shop("shopM"),
                new Shop("shopN"),
                new Shop("shopO"),
                new Shop("shopP"),
                new Shop("shopQ"),
                new Shop("shopR"),
                new Shop("shopS"),
                new Shop("shopT")
        );
    }

}
