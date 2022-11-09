package com.lengedyun.completableFuture;

import com.lengedyun.completableFuture.betterbuy.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @title: CompletableFuture
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/8 15:58
 */
public class CompletableFutureTest {

    public static void main(String[] args) {

        Shop shop = new Shop("shopA");
        Double aDouble = null;
        long start = System.nanoTime();
        //1.同步执行
        aDouble  = shop.getPrice("pc very nice");

        //2.异步调用
//        Future<Double> doubleFuture = shop.getPriceAsync("pc very nice");
        Future<Double> doubleFuture = shop.getPriceAsyncByFactory("pc very nice");

        //异步调用主程序可以继续执行
        otherOperation();

        try {
            //不设置超时时间会一直等待
            aDouble = doubleFuture.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(aDouble);
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("retrieval return after:" + retrievalTime);

    }


    private static void otherOperation() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.nanoTime() + ":current");

        }
    }

}
