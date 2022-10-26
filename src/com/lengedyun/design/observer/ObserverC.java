package com.lengedyun.design.observer;

/**
 * @title: Observer
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/26 14:26
 */
public class ObserverC implements Observer{


    @Override
    public void notify(String msg) {
        if (msg.contains("C")) {
            System.out.println("C receive msg: " + msg);
        }
    }
}
