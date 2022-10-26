package com.lengedyun.design.observer;

/**
 * @title: Observer
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/26 14:26
 */
public class ObserverA implements Observer {


    @Override
    public void notify(String msg) {
        if (msg.contains("A")) {
            System.out.println("A receive msg: " + msg);
        }
    }
}
