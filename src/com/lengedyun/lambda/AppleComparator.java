package com.lengedyun.lambda;

import com.lengedyun.func.Apple;

/**
 * @title: AppleComparator
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/19 14:55
 */
public class AppleComparator implements java.util.Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
