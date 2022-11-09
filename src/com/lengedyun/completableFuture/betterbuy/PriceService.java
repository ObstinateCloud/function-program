package com.lengedyun.completableFuture.betterbuy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * @title: PriceService
 * @description: 价格服务
 * @auther: zhangjianyun
 * @date: 2022/11/9 13:57
 */
public class PriceService {

    private List<Shop> shops;

    public PriceService(List<Shop> shops) {
        this.shops = shops;
    }

    //串行查询所有商店中某个商品的价格
    public   List<String> findPrices(String product) {
        long start = System.nanoTime();
//        return shops.stream().map(shop -> shop.getName() +":"+ shop.getPrice(product)).collect(Collectors.toList());
        //占位符
        List<String> list = shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
        System.out.println(" findPrices done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return list;
    }

    //并行查询所有商店中某个商品的价格 并行取决于线程池的大小 当线程数大于线程池总数时会，后面的线程需要等待 适合纯计算并行任务
    public  List<String> findPricesParallel(String product) {
        long start = System.nanoTime();
        //占位符
        List<String> list = shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
        System.out.println(" findPricesParallel done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return list;
    }

    //异步查询所有商店中某个商品的价格 和并行时采用同样的数据库连接池，受连接池影响
    public  List<String> findPricesAsync(String product) {
        long start = System.nanoTime();
        //每个商家创建一个查询流
        List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product)))
                .collect(Collectors.toList());

        //对流进行合并
        List<String> list = collect.stream()
                .map(CompletableFuture::join)   //等等所有异步操作结束
                .collect(Collectors.toList());
        System.out.println(" findPricesAsync done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return list;
    }

    public  final Executor executor = Executors.newFixedThreadPool(20, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true); //使用守护线程，不会阻止程序关停
            return thread;
        }
    });

    //异步查询所有商店中某个商品的价格 和并行时采用同样的数据库连接池，受连接池影响 加自定义执行器 极大提升性能 适合并行中有io操作场景
    public  List<String> findPricesAsyncCusExecutor(String product) {
        long start = System.nanoTime();
        //每个商家创建一个查询流
        List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product),executor))
                .collect(Collectors.toList());

        //对流进行合并
        List<String> list = collect.stream()
                .map(CompletableFuture::join)   //等等所有异步操作结束
                .collect(Collectors.toList());
        System.out.println(" findPricesAsyncCusExecutor done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return list;
    }
}
