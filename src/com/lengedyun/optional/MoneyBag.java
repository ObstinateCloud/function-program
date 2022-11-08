package com.lengedyun.optional;

import java.util.Optional;

/**
 * @title: MoneyBag
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 16:59
 */
public class MoneyBag {

    private Money money;

    private Optional<Money> moneyOptional;

    public Optional<Money> getMoneyOptional() {
        return moneyOptional;
    }

    public void setMoneyOptional(Optional<Money> moneyOptional) {
        this.moneyOptional = moneyOptional;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
