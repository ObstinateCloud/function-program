package com.lengedyun.design.strategy;

/**
 * @title: IsNumeric
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/14 16:50
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
