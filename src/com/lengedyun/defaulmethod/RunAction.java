package com.lengedyun.defaulmethod;

/**
 * @title: WalkAction
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 11:35
 */
public interface RunAction {

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    default void moveHorizontal(int step) {
        setX(getX() + step);
    }

    ;

    default void moveVertical(int step) {
        setY(getY() + step);
    }

}
