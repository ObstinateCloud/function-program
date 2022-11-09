package com.lengedyun.completableFuture.betterbuy;

/**
 * @title: ExchangeRateService
 * @description: 汇率服务 提供不同货币间转换
 * @auther: zhangjianyun
 * @date: 2022/11/9 16:31
 */
public class ExchangeRateService {

    public enum Money{

        EUR(10),USD(5)
        ;

        Money(double value) {
            this.value = value;
        }

        private String name;

        private double value;

    }

    private double rate;

    public double getRate(Money money1,Money money2) {

        return money1.value/money2.value;
    }
}
