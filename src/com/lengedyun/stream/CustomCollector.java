package com.lengedyun.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @title: CustomCollector
 * @description: 自定义器
 * 查找质数算法优化
 * @auther: zhangjianyun
 * @date: 2022/10/13 15:22
 */


public class CustomCollector {


    public static void main(String[] args) {
        commonImpl(1000);
    }

    //打印前n个数中的质数
    //计算从2到n的平方根做除数的数 中是否有能被n整除的数据
    public static void commonImpl(int n){
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(num -> isPrime(num)));

        System.out.println(collect.get(true).size());
        System.out.println(collect.get(true).toString());


    }

    public static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i->candidate % i ==0);

    }

    //优化方案 仅查看测试数，小于被测试数平方根，且能否被质数整除 即可


}
