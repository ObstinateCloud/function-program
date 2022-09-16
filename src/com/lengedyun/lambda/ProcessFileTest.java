package com.lengedyun.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @title: ProcessFile
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/9/16 10:15
 */
public class ProcessFileTest {

    public static void main(String[] args) {
        // 读文件方法
        try {
            String oneLine = processFile((BufferedReader br) -> br.readLine());
            System.out.println(oneLine);
            String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(twoLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processFile() throws IOException {
        //自带关闭流
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReader.readLine();
        }

    }

    private static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        //自带关闭流
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(bufferedReader);
        }

    }
}

@FunctionalInterface
interface BufferedReaderProcessor {

    String process(BufferedReader bufferedReader) throws IOException;

}
