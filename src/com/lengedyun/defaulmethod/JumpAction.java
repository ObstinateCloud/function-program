package com.lengedyun.defaulmethod;

/**
 * @title: JumpAction
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 11:34
 */
public interface JumpAction {

    int getLeft();

    int getRight();

    void setLeft(int left);

    void setRight(int right);

    void setAbsoluteSize(int left, int right);

    default void setRelativeSize(int left, int right) {
        setAbsoluteSize(getLeft() / left, getRight() / right);
    }
}
