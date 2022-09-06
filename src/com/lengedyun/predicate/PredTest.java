package com.lengedyun.predicate;

import com.lengedyun.func.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: PredTest
 * @description: 谓词 输入一个参数 ，返回一个boolean类型
 * @auther: zhangjianyun
 * @date: 2022/9/5 10:59
 */
public class PredTest {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(120,"yellow"));
        list.add(new Apple(120,"green"));
        list.add(new Apple(220,"yellow"));
        list.add(new Apple(320,"green"));
        list.add(new Apple(1890,"yellow"));
        list.add(new Apple(120,"green"));
        System.out.println("------------static method --------");
        List<Apple> listRes1 = Apple.filterApple(list,Apple::isGreenColor);
        listRes1.forEach(p->{
            System.out.println(p.toString());
        });
        List<Apple> listRes2 = Apple.filterApple(list,Apple::isHeavyWeight);
        listRes2.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("--------lambda---------");

        //使用lambda表达式
        List<Apple> filterApple = Apple.filterApple(list, (Apple a) -> a.getWeight() > 300 & "yellow".equals(a.getColor()));
        filterApple.forEach(p-> System.out.println(p.toString()));
        System.out.println("----------stream-------");
        //使用流
        List<Apple> collect = list.stream().filter(a -> a.getWeight() > 200 || "green".equals(a.getColor())).collect(Collectors.toList());
        collect.forEach(p-> System.out.println(p.toString()));


    }
}
