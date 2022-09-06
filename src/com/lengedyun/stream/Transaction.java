package com.lengedyun.stream;

/**
 * @title: Transaction
 * @description: 交易
 * @auther: zhangjianyun
 * @date: 2022/9/5 13:39
 */
public class Transaction {

    private int price;

    private Currency currency;

    public Transaction(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
