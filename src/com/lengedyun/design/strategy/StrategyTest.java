package com.lengedyun.design.strategy;

/**
 * @title: StrategyTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/14 16:53
 */
public class StrategyTest {

    public static void main(String[] args) {
         //策略模式常规写法
//        Validator numeric = new Validator(new IsNumeric());
//        boolean b1 = numeric.validate("AAA");
//        Validator lowerCase = new Validator(new IsAllLowerCase());
//        boolean ccc = lowerCase.validate("ccc");
//        System.out.println(b1);
//        System.out.println(ccc);


//        lambda写法
        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(validator.validate("aaaa"));
        Validator validator2 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(validator2.validate("123"));


    }
}
