package com.lengedyun.stream;

import com.lengedyun.stream.bo.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @title: StreamTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/5 13:40
 */
public class StreamTest {
    public static List<Student> classes = new ArrayList<>();

    public static void main(String[] args) {
        // 1.//流只能消费一次
//        Stream<Student> stream = transactionList.stream();
//        stream.forEach(p-> System.out.println(p.toString()));
//        stream.forEach(System.out::println);
        // 2. 中间操作 可以随意组合
//        printStudentList(middleOperator(classes));
//        mapOperator(classes).forEach(System.out::println);
//        findOperator(classes);



        // 3.终端操作 最终操作一下只能选择1个
//        System.out.println(matchOperator(classes));
//        System.out.println(reduceOperator(classes));
        // match
        //collect
        //Optional findAny
        // forEach
        // count
        // reduce

        //4 数值流应用
//        numRange();
        gouGuNum();

    }

    static {
        long currentTimeMillis = System.currentTimeMillis();
        long day = 1000 * 60 * 60 * 24;
        classes.add(new Student("张三", 12, new Date(currentTimeMillis - day * 287), true, "足球"));
        classes.add(new Student("李四", 12, new Date(currentTimeMillis - day * 231), true, "足球"));
        classes.add(new Student("张三三", 43, new Date(currentTimeMillis - day * 125), false, "足球"));
        classes.add(new Student("张三峰", 31, new Date(currentTimeMillis - day * 169), false, "乒乓球"));
        classes.add(new Student("王五", 17, new Date(currentTimeMillis - day * 12), true, "乒乓球"));
        classes.add(new Student("赵六", 8, new Date(currentTimeMillis - day * 125), true, "乒乓球"));
        classes.add(new Student("马七", 15, new Date(currentTimeMillis - day * 165), false, "羽毛球"));
        classes.add(new Student("马七", 25, new Date(currentTimeMillis - day * 165), false, "足球"));
        classes.add(new Student("杨八姐", 32, new Date(currentTimeMillis - day * 95), false, "羽毛球"));
        classes.add(new Student("李四海", 22, new Date(currentTimeMillis - day * 201), false, "篮球"));
        classes.add(new Student("王九分", 15, new Date(currentTimeMillis - day * 20), true, "足球"));
        classes.add(new Student("王九分", 15, new Date(currentTimeMillis - day * 199), false, "篮球"));
    }

    public static List<Student> getStudentList(){
        return classes;
    }


    public static void printStudentList(List<Student> studentList) {
        studentList.forEach(System.out::println);
    }

    //中间操作
    public static List<Student> middleOperator(List<Student> classes) {
        List<Student> res = null;
        //谓词筛选
//        res = classes.stream().filter(Student::isMan).collect(Collectors.toList());
        //去重 需要重新hashCode和equals方法
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().collect(Collectors.toList());
        // 截断
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().limit(5).collect(Collectors.toList());
        // 跳过
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().limit(5).skip(2).collect(Collectors.toList());

//        final List<Student> collect = classes.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        return res;
    }

    //映射
    public static List<String> mapOperator(List<Student> classes) {
        // 映射
//      List<String> collect = classes.stream().map(Student::getName).collect(Collectors.toList());
        // 映射串联
//        List<Integer> collectLength = classes.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
//        collectLength.forEach(System.out::println);

        //流的扁平化 将map产生的多个流，转换为一个流
        // eg 获取所有名字中使用到的汉字的集合 去重
        List<String> collect = classes.stream().map(Student::getName).map(n -> n.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());



        return collect;
    }

    //查找与匹配
    public static boolean matchOperator(List<Student> classes) {
        boolean res;
        // 有一个符合
//        res = classes.stream().anyMatch(s -> "李四".equals(s.getName()));
        // 全部符合
//        res = classes.stream().allMatch(s->s.getAge()>25);
        // 没有符合
        res = classes.stream().noneMatch(s -> s.getBirth().after(new Date()));
        return res;
    }

    //查找操作
    public static void findOperator(List<Student> classes) {
        //返回任意元素
        classes.stream().filter(p -> p.getAge() > 20).findAny().ifPresent(d -> System.out.println(d.getName()));

        //返回第一个符合条件
        classes.stream().filter(p -> p.getAge() > 20).findFirst().ifPresent(d -> System.out.println(d.getName()));

        //注意在并行流中无强制要求时，findAny效率更高

    }

    //规约计算
    public static Object reduceOperator(List<Student> classes) {
        // 求和 10 初始值
//        Integer reduce = classes.stream().map(Student::getAge).reduce(10, (a, b) -> a + b);
        // 利用求和函数
//        Integer reduce = classes.stream().map(Student::getAge).reduce(0, Integer::sum);
        // 求乘积
//        Integer reduce = classes.stream().map(Student::getAge).reduce(1, (a, b) -> a * b);

        //无初始值 //通过optional 可以判断是否存在元素
        Optional<Integer> reduce1 = classes.stream().map(Student::getAge).reduce(Integer::sum);

        // 计算最大 最小值
//        Optional<Integer> reduce2 = classes.stream().map(Student::getAge).reduce((x, y) -> x > y ? x : y);
//        final Integer reduce = reduce2.get();

        //简化
//        Optional<Integer> reduce3 = classes.stream().map(Student::getAge).reduce(Integer::max);
//        final Integer reduce = reduce3.get();

        // 流对min,max的优化
        Optional<Student> min = classes.stream().min(Comparator.comparing(Student::getAge));
        Integer reduce = min.get().getAge();


        //将所有人的姓名拼接为一个字符串
//        String reduce = classes.stream().map(Student::getName).reduce("", (a, b) -> a + b);
        // 提高字符串拼接效率 joining使用StringBuilder实现
//        String reduce = classes.stream().map(Student::getName).collect(Collectors.joining());

        return reduce;

    }

    //原始流特化 优化 int double等类型因拆装箱而导致的性能浪费
    public static void boxingStream(List<Student> classes){

        //年龄求和 两种方法 方法2避免重复拆装箱
        Integer reduce = classes.stream().map(Student::getAge).reduce(0,Integer::sum);
        int sum = classes.stream().mapToInt(Student::getAge).sum();

        //将IntStream装箱
        IntStream intStream = classes.stream().mapToInt(Student::getAge);
        Stream<Integer> boxed = intStream.boxed();

        //年龄求最大值
        Optional<Integer> reduce1 = classes.stream().map(Student::getAge).reduce(Integer::max);
        //OptionalInt 基于Optional的封装
        OptionalInt max = classes.stream().mapToInt(Student::getAge).max();
        max.orElse(1);
    }

    //数值范围
    public static void numRange(){
        long count = IntStream.range(1, 100).filter(i -> i % 2 == 0).count();
        System.out.println(count);
        //rangeClosed 右闭区间
        long count1 = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count();
        System.out.println(count1);


    }

    //查找a-b范围内的勾股数如(3,4,5)
    public static void gouGuNum(){
        //方法1
//        Stream<int[]> stream = IntStream.rangeClosed(1, 100)
//                .boxed()
//                .flatMap(a -> IntStream.rangeClosed(a, 100)
//                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0  //
//                        ).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                );

        //方法2 优化 先穷举再判断
        Stream<double[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
                );
        stream.forEach(p-> System.out.println(p[0]+","+p[1]+","+p[2]));

    }



}
