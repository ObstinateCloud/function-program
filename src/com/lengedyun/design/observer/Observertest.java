package com.lengedyun.design.observer;

/**
 * @title: Observertest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/26 14:11
 */
public class Observertest {


    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        subject.registerObserver(new ObserverA());
        subject.registerObserver(new ObserverB());
        subject.registerObserver(new ObserverC());



        //lambda 优化
        subject.registerObserver((String msg) -> {
            if (msg.contains("D")) {
                System.out.println("D receive msg:" + msg);
            }
        });

        subject.notifyObservers(" D begin work");
    }
}
