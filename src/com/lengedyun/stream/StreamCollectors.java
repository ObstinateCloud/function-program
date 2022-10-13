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
//        countCollectors();
        // 分组统计
//        groupStudent();

        //分区统计
        partitioningBy();
    }


    //规约和汇总
    public static void countCollectors() {
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
//        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining(",", "前缀", "后缀"));
//        System.out.println(collect);


        // 结合reduce使用
        //计算最大值
//        Optional<Student> collect1 = studentList.stream().collect(Collectors.reducing((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2));
//        System.out.println(collect1.get().getAge());

        //三个参数
//        Integer collect = studentList.stream().collect(Collectors.reducing(0, Student::getAge, Integer::sum));
//        System.out.println(collect);

    }

    //分组
    public static void groupStudent() {
        //用属性分组
//        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getHobby));
//        Map<Integer, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
//        Map<Boolean, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::isMan));    studentList.stream().collect(Collectors.groupingBy(Student::isMan));
        // 按需求分组
//        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(s -> {
//            if (s.getAge() < 18) {
//                return "未成年";
//            } else if (s.getAge() >= 18 && s.getAge() < 35) {
//                return "青年";
//            } else {
//                return "中年";
//            }
//        }));

        //多级分组1
//        Map<Boolean, Map<String, List<Student>>> collect = studentList.stream().collect(Collectors.groupingBy(Student::isMan, Collectors.groupingBy(s -> {
//            if (s.getAge() < 18) {
//                return "未成年";
//            } else if (s.getAge() >= 18 && s.getAge() < 35) {
//                return "青年";
//            } else {
//                return "中年";
//            }
//        })));


        //多级分组2 三个参数
        Map<Boolean, Map<String, HashSet<Student>>> collect = studentList.stream().collect(Collectors.groupingBy(Student::isMan, Collectors.groupingBy(s -> {
            if (s.getAge() < 18) {
                return "未成年";
            } else if (s.getAge() >= 18 && s.getAge() < 35) {
                return "青年";
            } else {
                return "中年";
            }
        }, Collectors.toCollection(HashSet::new))));

        //多级分组扩展 统计各分组的学生人数
//        Map<String, Long> collect = studentList.stream().collect(Collectors.groupingBy(Student::getHobby, Collectors.counting()));
        //多级分组扩展 统计各分组的学生最大年龄
//        Map<String, Optional<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getHobby, Collectors.maxBy((s1, s2) -> s1.getAge() > s2.getAge() ? s1.getAge() : s2.getAge())));
        //去掉optional
//        Map<String, Student> collect = studentList.stream().collect(Collectors.groupingBy(Student::getHobby, Collectors.collectingAndThen(Collectors.maxBy((s1, s2) -> s1.getAge() > s2.getAge() ? s1.getAge() : s2.getAge()), Optional::get)));
//        Map<String, Student> collect = studentList.stream().collect(Collectors.groupingBy(Student::getHobby, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getAge)), Optional::get)));
        
        System.out.println(collect.toString());
    }

    //分区 分区是一种特殊的分组 分区的结果只有两种
    public static void partitioningBy(){
        //分区和分组效果一样
        Map<Boolean, List<Student>> collect = studentList.stream().collect(Collectors.partitioningBy(Student::isMan));
        Map<Boolean, List<Student>> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::isMan));


        System.out.println(collect.toString());
        System.out.println(collect1.toString());


    }

}
