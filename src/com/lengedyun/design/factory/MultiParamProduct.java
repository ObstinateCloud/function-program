package com.lengedyun.design.factory;

/**
 * @title: MultiParamProduct
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 14:23
 */
public interface MultiParamProduct<T,U,V,R> {

    R apply(T t,U u,V v);
}
