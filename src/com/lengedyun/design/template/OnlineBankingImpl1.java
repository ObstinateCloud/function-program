package com.lengedyun.design.template;

/**
 * @title: OnlineBanking
 * @description: 网上银行抽象类
 * @auther: zhangjianyun
 * @date: 2022/10/24 10:26
 */
public  class OnlineBankingImpl1 extends OnlineBanking{


    @Override
    void makeCustomerHappy(BankCustomer customer) {
        System.out.println(customer.getId()+" give you money");
    }
}
