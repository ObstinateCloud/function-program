package com.lengedyun.defaulmethod;

/**
 * @title: Action
 * @description: T游戏动作
 * @auther: zhangjianyun
 * @date: 2022/11/4 11:29
 */
public interface GameAction {

    void setStep(int step);

    int getStep();

    //默认方法不需要子类强制实现
    default void dealStep(int step) {
        System.out.println("parent dealStep");
        setStep((getStep()+step)*2);
    }
}
