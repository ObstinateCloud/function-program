package com.lengedyun.completableFuture.betterbuy;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @title: Shop
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/8 16:00
 */
public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //查询价格 同步
    public double getPrice(String product) {
        return calcPrice(product);
    }
    //查询价格和折扣 同步
    public String getPriceDiscount(String product) {
        double price = calcPrice(product);
        DiscountServcie.Code code = DiscountServcie.Code.
                values()[new Random().nextInt(DiscountServcie.Code.values().length)];
        return String.format("%s:%.2f:%s",name,price,code);
    }

    //异步执行
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calcPrice(product);
                //设置future的返回值
//                System.out.println(2/0);
                future.complete(price);
            } catch (Exception e) {
                //捕捉异常返回给客户端
                future.completeExceptionally(e);
            }

        }).start();
        return future;
    }

    //异步执行 使用工厂方法创建
    public Future<Double> getPriceAsyncByFactory(String product) {

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> calcPrice(product));

        return future;
    }


    private double calcPrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);

    }

    private void delay() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


