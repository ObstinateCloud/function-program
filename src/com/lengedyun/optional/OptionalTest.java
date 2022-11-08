package com.lengedyun.optional;

import java.util.Optional;

/**
 * @title: OptionalTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/4 17:03
 */
public class OptionalTest {


    public static void main(String[] args) {
        //代码逻辑 容易引发空指针
//        String name1 = new People().getMoneyBag().getMoney().getName();
//        System.out.println(name1);


        //传统写法
//        String name = getMoneyName(new People());
//        System.out.println(name);

        //Optional优化
//        String moneyName = getMoneyNameOptional(new People());

        People people = new People();
        MoneyBag moneyBag = new MoneyBag();
        Money money = new Money();
        money.setName("RMB");
        money.setNum(100);
        moneyBag.setMoney(money);
        people.setMoneyBag(moneyBag);

        Optional<Money> om = Optional.of(money);
        moneyBag.setMoneyOptional(om);
        Optional<MoneyBag> omb = Optional.of(moneyBag);
        people.setMoneyBagOptional(omb);

        //直接用Optional处理
        String moneyName = getMoneyNameOptional(people);
        System.out.println(moneyName);



;

        //创建null Optional对象
        Optional<People> empty = Optional.empty();
        //创建非空的Optional 对象
        Optional<People> op = Optional.of(people);
        //创建一个可以为空的 optional对象
        Optional<People> optionalPeople = Optional.ofNullable(new People());
        //map方法从optional对象中获取值
        Optional<MoneyBag> moneyBag2 = op.map(People::getMoneyBag);
        //flatMap 用于连接Optional对象
        String moneyNameOptionaFlatMap = getMoneyNameOptionalFlatMap(people);
        System.out.println(moneyNameOptionaFlatMap+"+++++");

        //Optional对象不支持序列化


    }


    public static String getMoneyName(People people) {
        if (people != null) {
            MoneyBag moneyBag = people.getMoneyBag();
            if (moneyBag != null) {
                Money money = moneyBag.getMoney();
                if (money != null) {
                    return money.getName();
                }else {
                    return "money is null";
                }
            }else {
                return "money is null";
            }

        }
        return "people is null";
    }

    public static String getMoneyNameOptional(People people) {

        String name = Optional.ofNullable(people)
                .map(People::getMoneyBag)
                .map(MoneyBag::getMoney)
                .map(Money::getName).orElseThrow(()->new NullPointerException("obj is null"));
        return name;
    }

    public static String getMoneyNameOptionalFlatMap(People people) {

        String name = Optional.ofNullable(people)
                .flatMap(People::getMoneyBagOptional)
                .flatMap(MoneyBag::getMoneyOptional)
                .map(Money::getName).orElseThrow(()->new NullPointerException("xxx is null"));
        return name;
    }
}
