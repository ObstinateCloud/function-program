package com.lengedyun.lambda;

import com.lengedyun.func.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @title: MethodQuote
 * @description: 方法引用
 * @auther: zhangjianyun
 * @date: 2022/9/19 11:05
 */
public class MethodQuote {

    public static void main(String[] args) {
        // 1.静态方法引用
//        Integer.parseInt("233")=======>Integer::parseInt
        // 2.任意类型实例方法引用
//        new String().length() =======>String::length
        // 3.现有对象类型实例方法引用
        Apple red = new Apple(12, "red");
//        red.getWeight() =======> red::getWeight
        // 4. 下面两种等价写法
        List<String> str = Arrays.asList("a","b","C","d");
//        str.sort((s1,s2)->s1.compareToIgnoreCase(s2));
//        str.sort(String::compareToIgnoreCase);
        
        // 5.无参构造函数引用
        Supplier<Apple> appleSupplier = ()->new Apple(); //lambda
//        Supplier<Apple> appleSupplier = Apple::new; //构造函数引用
        Apple apple = appleSupplier.get();

        // 6.一个参构造函数引用
//        Function<Integer,Apple> function = integer -> new Apple(integer);
        Function<Integer,Apple> function = Apple::new; //构造函数引用
        Apple apple1 = function.apply(110);

        // 7.两个参数构造函数引用
//        BiFunction<Integer,String,Apple> biFunction = (weight,color)->new Apple(weight,color);
        BiFunction<Integer,String,Apple> biFunction = Apple::new;

        Apple apple2 = biFunction.apply(110, "red");

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(100,"red"));
        appleList.add(new Apple(200,"red"));
        appleList.add(new Apple(300,"blue"));
        appleList.add(new Apple(120,"yellow"));
        appleList.add(new Apple(70,"green"));
        appleList.add(new Apple(70,"blue"));
//        sortApples6(appleList);
//        appleList.forEach(p-> System.out.println(p.getWeight()+","+p.getColor()));
//        predicateMix(appleList);

        System.out.println(funMix(5));

    }

    //排序苹果列表实现过程优化 方式1 传递代码
    public static void sortApples1(List<Apple> appleList){
        appleList.sort(new AppleComparator());

    }

    //排序苹果列表实现过程优化 方式2 使用匿名类
    public static void sortApples2(List<Apple> appleList){
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

    }

    //排序苹果列表实现过程优化 方式3 使用lambda
    public static void sortApples3(List<Apple> appleList){
        appleList.sort((Apple o1,Apple o2)->o1.getWeight().compareTo(o2.getWeight()));
        appleList.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));

    }

    //排序苹果列表实现过程优化 方式4 使用lambda
    public static void sortApples4(List<Apple> appleList){
//        Comparator<Apple> comparator = Comparator.comparing(a->a.getWeight());
//        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);
//        appleList.sort(comparator);

        //终极优化
        // import static java.util.Comparator.comparing;
        appleList.sort(comparing(Apple::getWeight));

    }

    //排序苹果列表实现过程优化-逆序排序 方式5 使用lambda
    public static void sortApples5(List<Apple> appleList){

        appleList.sort(comparing(Apple::getWeight).reversed());

    }

    //排序苹果列表实现过程优化-比较器链 方式6 使用lambda
    public static void sortApples6(List<Apple> appleList){
        //重量相同时 ，按照颜色来排
        appleList.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));

    }

    //谓词复合
    public static void  predicateMix(List<Apple> appleList){
        // 非 negate
        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
        Predicate<Apple> notRedApple = redApple.negate();
        // and
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight()>100);
        // or
        Predicate<Apple> notRedOrHeavy = notRedApple.or(apple -> apple.getWeight() > 100);
//        List<Apple> collect = appleList.stream().filter(redApple).collect(Collectors.toList());
//        List<Apple> collect = appleList.stream().filter(notRedApple).collect(Collectors.toList());
//        List<Apple> collect = appleList.stream().filter(redAndHeavyApple).collect(Collectors.toList());
        List<Apple> collect = appleList.stream().filter(notRedOrHeavy).collect(Collectors.toList());
        collect.forEach(p->{
            System.out.println(p.getWeight()+","+p.getColor());
        });

    }


    //函数复合
    public static Integer  funMix(Integer num) {
        Integer res = 0;
        // andThen 先执行function1 再执行function2
        Function<Integer, Integer> function1 = i-> i+10;
        Function<Integer, Integer> function2 = i-> i*10;
        Function<Integer, Integer> function3 = function1.andThen(function2);
//        res = function3.apply(num);
        // compose 先执行function2 再执行function1
        Function<Integer, Integer> function4 = function1.compose(function2);
        res = function4.apply(num);
        return res;

    }
}
