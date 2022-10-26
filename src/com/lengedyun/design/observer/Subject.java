package com.lengedyun.design.observer;

/**
 * @title: Subject
 * @description: 注册
 * @auther: zhangjianyun
 * @date: 2022/10/26 14:33
 */
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObservers(String msg);

}
