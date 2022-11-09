package com.lengedyun.completableFuture.betterbuy;

import java.util.Random;

/**
 * @title: DelayJob
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/9 14:48
 */
public class DelayJob {

    public static void delay() {
        int delay = new Random().nextInt(1000)+100;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
