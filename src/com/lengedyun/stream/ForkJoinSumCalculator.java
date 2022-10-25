package com.lengedyun.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @title: ForkJoinSumCalculator
 * @description: 用分支/合并框架执行并行求和
 * @auther: zhangjianyun
 * @date: 2022/10/14 14:19
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private  long[] numbers;

    private  int start;

    private  int end;

    //任务拆分大小
    public static long THRESHOLD = 10_000;

    public static Set<String> taskSet = new HashSet<>();


    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        int length = end -start;
        if(length<=THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);
        taskSet.add(leftTask.toString());
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);
        taskSet.add(rightTask.toString());
        Long rightResult = rightTask.compute(); //对第二个任务再次分解
        Long leftResult = leftTask.join(); //获取第一个子任务的执行结果

        return leftResult+rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start;i<end;i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] longs = LongStream.rangeClosed(1, 1000000).toArray();

        ForkJoinTask<Long> task = new ForkJoinSumCalculator(longs);

        Long invoke = new ForkJoinPool().invoke(task);
        System.out.println(invoke);

        System.out.println(taskSet.size());

    }
}
