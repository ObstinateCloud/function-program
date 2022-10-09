package com.lengedyun.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @title: StreamCreate
 * @description: 创建流
 * @auther: zhangjianyun
 * @date: 2022/10/8 17:14
 */
public class StreamCreate {


    public static void main(String[] args) {
        //通过值创建流
//        Stream<String> strStream = Stream.of("java 8","Lambda","Stream","in action","function program");
//        strStream.map(String::toUpperCase).forEach(System.out::println);
//        //空流
//        Stream<Integer> intStream = Stream.empty();

        //数组创建流
//        int[] numbers = {1,2,3,4,5,7};
//        IntStream stream = Arrays.stream(numbers);
//        Integer[] numbers1 = {1,2,3,4,5,7};
//        Stream<Integer> stream1 = Arrays.stream(numbers1);

        //文件创建流
//        createStreamFromFile();

        // 函数创建无限流
        funStream();

    }

    //文件生成流
    public static void createStreamFromFile(){
        //查询不重复单词数量
        long  uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("filetest.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line->Arrays.stream(line.split("")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        }catch (IOException ioe){

        }
    }

    //函数生成流 用于创建无限流
    public static void funStream(){
        //打印所有的偶数 eg 此处人为限制 0为初始值 iterate 需要一个指定的lambda来确定后续元素
//        Stream.iterate(0,n->n+2)
//                .limit(100)
//                .forEach(System.out::println);

        // 答应斐波那契数列  0,1,1,2,3,5,8,13....

//        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
//                .limit(10)
//                .map(p->p[0])
//                .forEach(System.out::println);

        //生成随机数 generate 固定返回值的lambda
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }



}
