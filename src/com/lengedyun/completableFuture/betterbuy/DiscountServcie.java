package com.lengedyun.completableFuture.betterbuy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @title: DiscountServcie
 * @description: 折扣服务
 * @auther: zhangjianyun
 * @date: 2022/11/9 13:58
 */
public class DiscountServcie {

    private List<Shop> shops;

    public DiscountServcie(List<Shop> shops) {
        this.shops = shops;
    }

    public enum Code{
        NONE(0),SILVER(5),GOLD(10),PLATINUM(15),DIAMOND(20)
        ;
        private int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote){
        return quote.getShopName()+" price is "+DiscountServcie.apply(quote.getPrice(),quote.getDiscountCode());
    }

    private static String apply(double price, Code discountCode) {
        DelayJob.delay();
        return String.format("%.2f",price*(100-discountCode.percentage)/100);

    }

    //查询折扣价格 同步
    public List<String> findDiscountPrice(String product){
        long start = System.nanoTime();

        List<String> collect = shops.stream()
                .map(shop -> shop.getPriceDiscount(product))
                .map(Quote::parse)
                .map(DiscountServcie::applyDiscount)
                .collect(Collectors.toList());
        System.out.println("findDiscountPrice done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return collect;
    }

    public  final Executor executor = Executors.newFixedThreadPool(20, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true); //使用守护线程，不会阻止程序关停
            return thread;
        }
    });

    //查询折扣价格 异步
    public List<String> findDiscountPriceAsync(String product){
        long start = System.nanoTime();
        List<CompletableFuture<String>> collect1 = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceDiscount(product), executor)) //异步方式获取shop中商品的价格
                .map(future -> future.thenApply(Quote::parse))// quote对象存在是对其返回的值进行转换
                //使用另一个异步任务构造期望的Future 申请折扣， thenCompose对两个CompletableFuture异步线程进行流水线操作 第二步操作依赖第一步操作的结果
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> DiscountServcie.applyDiscount(quote), executor)))
                .collect(Collectors.toList());


        List<String> collect = collect1.stream()
                .map(CompletableFuture::join) //等待流中所有的Future执行完毕，提取各种返回值
                .collect(Collectors.toList());
        System.out.println("findDiscountPriceAsync done in " + (System.nanoTime() - start) / 1_000_000 + " ms");
        return collect;
    }


    //查询折扣价格 异步 返回stream
    public Stream<CompletableFuture<String>> findDiscountPriceAsyncStream(String product){
        long start = System.nanoTime();
        Stream<CompletableFuture<String>> completableFutureStream = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceDiscount(product), executor)) //异步方式获取shop中商品的价格
                .map(future -> future.thenApply(Quote::parse))// quote对象存在是对其返回的值进行转换
                //使用另一个异步任务构造期望的Future 申请折扣， thenCompose对两个CompletableFuture异步线程进行流水线操作 第二步操作依赖第一步操作的结果
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> DiscountServcie.applyDiscount(quote), executor)))
                ;
        //每个Future执行完后都打印
        completableFutureStream.map(stream -> stream.thenAccept(System.out::println));
        return completableFutureStream;
    }



    //查询折扣价格 异步 thenCombine对没有关系的 CompletableFuture整合
//    public List<String> findDiscountPriceAsync1(String product){
//        ExchangeRateService exchangeRateService = new ExchangeRateService();
//
//        Shop shop = new Shop("A");
//        CompletableFuture.supplyAsync(() -> shop.getPriceDiscount(product), executor) //异步方式获取shop中商品的价格
//                .thenCombine(CompletableFuture.supplyAsync(() ->exchangeRateService.getRate(ExchangeRateService.Money.EUR,ExchangeRateService.Money.USD)),(price,rate)->price*rate)
//        ;
//
//        return null;
//    }


}
