package com.lengedyun.design.respchains;

/**
 * @title: SpellCheckProcessing
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 11:24
 */
public class SpellCheckProcessing extends ProcessObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.toLowerCase();
    }
}
