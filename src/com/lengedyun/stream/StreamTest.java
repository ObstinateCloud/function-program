package com.lengedyun.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @title: StreamTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/5 13:40
 */
public class StreamTest {

    public static void main(String[] args) {
        //筛选 金额较高的交易按照货币进行分组
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction(500,new Currency("RMB")));
        transactionList.add(new Transaction(5020,new Currency("RMB")));
        transactionList.add(new Transaction(1500,new Currency("Pound")));
        transactionList.add(new Transaction(5200,new Currency("RMB")));
        transactionList.add(new Transaction(3500,new Currency("RMB")));
        transactionList.add(new Transaction(5280,new Currency("Aud")));
        transactionList.add(new Transaction(3300,new Currency("Dollar")));
        transactionList.add(new Transaction(1300,new Currency("Pound")));
        transactionList.add(new Transaction(50,new Currency("RMB")));
        transactionList.add(new Transaction(3000,new Currency("RMB")));
        transactionList.add(new Transaction(5180,new Currency("Aud")));
        transactionList.add(new Transaction(3200,new Currency("Dollar")));

        Map<Currency,List<Transaction>> currencyListMap = new HashMap<>();
        //常规写法
//        transactionList.forEach(p->{
//            if(p.getPrice()>1000){
//                Currency currency = p.getCurrency();
//                List<Transaction> transactionListCurrency = currencyListMap.get(currency);
//                if(transactionListCurrency ==null){
//                    transactionListCurrency = new ArrayList<>();
//                    currencyListMap.put(currency,transactionListCurrency);
//                }
//                transactionListCurrency.add(p);
//            }
//
//        });

        //通过stream操作 串行流
//      currencyListMap= transactionList.stream().filter(t -> t.getPrice()>1000)
//                .collect(Collectors.groupingBy(Transaction::getCurrency));

        //通过stream操作 并行流
        currencyListMap = transactionList.parallelStream().filter(t -> t.getPrice()>1000)
                .collect(Collectors.groupingBy(Transaction::getCurrency));

        Map<Currency, List<Transaction>> finalCurrencyListMap = currencyListMap;
        currencyListMap.keySet().forEach(p->{
            System.out.print(p.getName()+":");
            for (Transaction m : finalCurrencyListMap.get(p)) {
                System.out.print(m.getPrice() + ",");
            }
            System.out.println("\n");
        });


    }


}
