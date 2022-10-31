package com.lengedyun.design.respchains;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @title: ChainsTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:24
 */
public class ChainsTest {


    public static void main(String[] args) {

        ProcessObject<String> p1 = new HanderTextProcessing();
        ProcessObject<String> p2 = new SpellCheckProcessing();

        p1.setSuccessor(p2);

        System.out.println(p1.handle("LegendYun"));

        //lambda 优化
        UnaryOperator<String> handle  = (String text)->"handle:"+text;
        UnaryOperator<String> spellCheck  = (String text)->text.toLowerCase();
        Function<String, String> pipeline = handle.andThen(spellCheck);
        System.out.println(pipeline.apply("LegendYun"));

    }
}
