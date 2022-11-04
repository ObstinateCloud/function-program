package com.lengedyun.defaulmethod;

/**
 * @title: RoleAction
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 11:44
 */
public class RoleAction implements GameAction,JumpAction,RunAction{
    @Override
    public void setStep(int step) {

    }

    @Override
    public int getStep() {
        return 0;
    }

    @Override
    public int getLeft() {
        return 0;
    }

    @Override
    public int getRight() {
        return 0;
    }

    @Override
    public void setLeft(int left) {

    }

    @Override
    public void setRight(int right) {

    }

    @Override
    public void setAbsoluteSize(int left, int right) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void dealStep(int step) {
        System.out.println("son action");
    }
}
