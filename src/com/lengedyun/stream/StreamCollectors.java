package com.lengedyun.stream;

import com.lengedyun.stream.bo.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @title: StreamCollectors
 * @description: 用流收集数据
 * @auther: zhangjianyun
 * @date: 2022/10/9 11:38
 */
public class StreamCollectors {

    private static List<Student> studentList = StreamTest.getStudentList();

    public static void main(String[] args) {
        countCollectors();
    }




    //规约和汇总
    public static void countCollectors(){
        // 计数
//        Long collect = studentList.stream().collect(Collectors.counting());
//        System.out.println(collect);

        //等效写法
//        long count = studentList.stream().count();
//        System.out.println(count);

        //最大，最小值
//        Optional<Student> collect1 = studentList.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
//        System.out.println(collect1.get().getAge());
        //等效写法
//        Optional<Student> max = studentList.stream().max(Comparator.comparing(Student::getAge));
//        System.out.println(max.get().getAge());

        //求和
//        Integer collect = studentList.stream().collect(Collectors.summingInt(Student::getAge));
//        System.out.println(collect);
//
//        int sum = studentList.stream().mapToInt(Student::getAge).sum();
//        System.out.println(sum);


        //平均数
//        Double collect1 = studentList.stream().collect(Collectors.averagingInt(Student::getAge));
//        System.out.println(collect1);
//
//        OptionalDouble average = studentList.stream().mapToInt(Student::getAge).average();
//        System.out.println(average.getAsDouble());


        //一次计算多个值返回一个封装对象
//        IntSummaryStatistics collect = studentList.stream().collect(Collectors.summarizingInt(Student::getAge));
//        System.out.println(collect.toString());

        //连接字符串
//        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining());
//        System.out.println(collect);

//        String collect1 = studentList.stream().map(Student::toString).collect(Collectors.joining());
//        System.out.println(collect1);
//      joining 重载 拼接连接符
//        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining(","));
        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining(",","前缀","后缀"));
        System.out.println(collect);


        // 结合reduce使用

    }

}
