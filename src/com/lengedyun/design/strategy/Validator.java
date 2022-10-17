package com.lengedyun.design.strategy;

/**
 * @title: Validator
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/14 16:52
 */
public class Validator {

    private  ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }
}
