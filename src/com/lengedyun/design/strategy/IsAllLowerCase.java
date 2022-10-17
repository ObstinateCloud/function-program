package com.lengedyun.design.strategy;

/**
 * @title: IsAllLowerCase
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/14 16:49
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
