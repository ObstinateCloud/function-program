package com.lengedyun.stream;

import com.lengedyun.stream.bo.Student;

import java.util.*;
import java.util.stream.Collectors;
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
        printStudentList(middleOperator(classes));

        // 3.终端操作 最终操作一下只能选择1个






    }

    static {
        long currentTimeMillis = System.currentTimeMillis();
        long day = 1000*60*60*24;
        classes.add(new Student("张三",12,new Date(currentTimeMillis-day*287),true));
        classes.add(new Student("李四",12,new Date(currentTimeMillis-day*231),true));
        classes.add(new Student("张三三",43,new Date(currentTimeMillis-day*125),false));
        classes.add(new Student("张三峰",31,new Date(currentTimeMillis-day*169),false));
        classes.add(new Student("王五",17,new Date(currentTimeMillis-day*12),true));
        classes.add(new Student("赵六",8,new Date(currentTimeMillis-day*125),true));
        classes.add(new Student("马七",15,new Date(currentTimeMillis-day*165),false));
        classes.add(new Student("马七",25,new Date(currentTimeMillis-day*165),false));
        classes.add(new Student("杨八姐",32,new Date(currentTimeMillis-day*95),false));
        classes.add(new Student("李四海",22,new Date(currentTimeMillis-day*201),false));
        classes.add(new Student("王九分",15,new Date(currentTimeMillis-day*20),true));
        classes.add(new Student("王九分",15,new Date(currentTimeMillis-day*199),false));
    }


    public static void printStudentList(List<Student> studentList){
        studentList.forEach(System.out::println);
    }

    //中间操作
    public static List<Student> middleOperator(List<Student> classes){
        List<Student> res = null;
        //谓词筛选
//        res = classes.stream().filter(Student::isMan).collect(Collectors.toList());
        //去重 需要重新hashCode和equals方法
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().collect(Collectors.toList());
        // 截断
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().limit(5).collect(Collectors.toList());
        // 跳过
//        res = classes.stream().filter(p-> p.getAge()>10).distinct().limit(5).skip(2).collect(Collectors.toList());

        return res;
    }


}
