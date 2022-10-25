package com.lengedyun.design.template;

import java.util.function.Consumer;

/**
 * @title: OnlineBanking
 * @description: 网上银行抽象类
 * @auther: zhangjianyun
 * @date: 2022/10/24 10:26
 */
public  class OnlineBankingLambda {



    public void processCustomerLambda(int id, Consumer<BankCustomer> makeCustomerHappy){
        //根据不同的用户提供不同的方案
        BankCustomer customer = new BankCustomer(id);
        makeCustomerHappy.accept(customer);
    }





}
