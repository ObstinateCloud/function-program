package com.lengedyun.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: SubjectImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/26 14:34
 */
public class SubjectImpl implements Subject{

    List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        observers.forEach(observer -> observer.notify(msg));
    }
}
