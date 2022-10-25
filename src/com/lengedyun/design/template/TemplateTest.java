package com.lengedyun.design.template;

/**
 * @title: TemplateTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/10/24 10:36
 */
public class TemplateTest {

    public static void main(String[] args) {
        OnlineBanking banking1 = new OnlineBankingImpl1();
        banking1.processCustomer(1);

        OnlineBanking banking2 = new OnlineBankingImpl2();
        banking2.processCustomer(2);

        //lambda写法 可以随意变更用户行为
        new OnlineBankingLambda().processCustomerLambda(12,customer -> System.out.println(customer.getId()+" hello,give you everything"));
        new OnlineBankingLambda().processCustomerLambda(22,customer -> System.out.println(customer.getId()+" hello,give you job"));
    }
}
