package com.lengedyun.defaulmethod;

/**
 * @title: GameTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 11:46
 */
public class GameTest {

    public static void main(String[] args) {
        RoleAction roleAction = new RoleAction();
        roleAction.dealStep(5);
        roleAction.moveHorizontal(1);
    }
}
