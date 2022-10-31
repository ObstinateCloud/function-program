package com.lengedyun.design.respchains;

/**
 * @title: HanderTextProcessing
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/31 8:59
 */
public class HanderTextProcessing extends ProcessObject<String> {


    @Override
    protected String handleWork(String input) {


        return "handle:"+ input;
    }
}
