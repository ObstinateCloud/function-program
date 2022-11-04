package com.lengedyun.extendrule;

/**
 * @title: ExtendTest
 * @description: 菱形继承问题
 * @auther: zhangjianyun
 * @date: 2022/11/4 14:52
 */
public class ExtendTest {

    public static void main(String[] args) {
        //1.继承的两个接口包含同样的默认方法时，实现类必须重新此方法，要调用某个父接口的方法时，需要显式申明 A.super.xxx()
        C1 c1 = new C1();
        c1.sayHello();

        //2.多重继承时 A->B->C 显示申明高于默认方法，离实现类越近优先级越高
        D1 d1 =new D1();
        d1.sayHello();

        //3.菱形继承 a<-b a<-c b,c<-d
        D2 d2 = new D2();
        d2.sayHello();

    }
}
