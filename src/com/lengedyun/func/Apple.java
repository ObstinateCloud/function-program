package com.lengedyun.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @title: Apple
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/5 11:00
 */
public class Apple {

    private int weight;

    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static boolean isGreenColor(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyWeight(Apple apple){
        return 150< apple.getWeight();
    }

    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
