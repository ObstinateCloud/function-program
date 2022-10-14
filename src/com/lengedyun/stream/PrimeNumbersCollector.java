package com.lengedyun.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @title: PrimeNumbersCollector
 * @description: 自定义质数收集器
 * @auther: zhangjianyun
 * @date: 2022/10/13 15:54
 */
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    /**
     * 返回一个在调用是创建累加器的方法
     *
     * @return
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {

        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    /**
     * 将找到的质数或非质数添加到对应的累加器列表
     * @return
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {

        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate)).add(candidate);
        };
    }

    /**
     * 收集器数据并行工作
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

        //将map2中对应类型的数据据添加到map1中

        return (Map<Boolean,List<Integer>> map1,Map<Boolean,List<Integer>> map2)->{
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        //收集过程最后无需类型转换 因此用identity收尾
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }


    public boolean isPrime(List<Integer> accList, Integer candidate){
        return accList.stream().noneMatch(i -> candidate % i == 0);
    }
}
