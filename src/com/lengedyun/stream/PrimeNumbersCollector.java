package com.lengedyun.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>,Map<Boolean,List<Integer>>> {


    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
