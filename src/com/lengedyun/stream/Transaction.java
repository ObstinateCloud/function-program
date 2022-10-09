package com.lengedyun.stream;

/**
 * @title: Transaction
 * @description: 交易
 * @auther: zhangjianyun
 * @date: 2022/9/5 13:39
 */
public class Transaction {

    private int price;

    private String city;

    private Currency currency;

    public Transaction(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public Transaction(int price, String city, Currency currency) {
        this.price = price;
        this.city = city;
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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "price=" + price +
                ", city='" + city + '\'' +
                ", currency=" + currency +
                '}';
    }
}
