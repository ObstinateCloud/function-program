package com.lengedyun.optional;

import java.util.Optional;

/**
 * @title: People
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 16:58
 */
public class People {

    private MoneyBag moneyBag;

    Optional<MoneyBag> moneyBagOptional;

    public MoneyBag getMoneyBag() {
        return moneyBag;
    }

    public void setMoneyBag(MoneyBag moneyBag) {
        this.moneyBag = moneyBag;
    }

    public Optional<MoneyBag> getMoneyBagOptional() {
        return moneyBagOptional;
    }

    public void setMoneyBagOptional(Optional<MoneyBag> moneyBagOptional) {
        this.moneyBagOptional = moneyBagOptional;
    }
}
