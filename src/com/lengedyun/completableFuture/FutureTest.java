package com.lengedyun.completableFuture;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @title: FutureTest
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/11/8 15:23
 */
public class FutureTest {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<BigDecimal> submit = executor.submit(new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                return doubleComputation();
            }

            private BigDecimal doubleComputation() {
                BigDecimal result = new BigDecimal(0);
                for (int i = 0; i < 100000; i++) {
                    result = result.add(new BigDecimal(i));
                }
                return result;
            }
        });

        //doOther
        for (int i = 0; i < 1000; i++) {
            System.out.println(System.currentTimeMillis()+":hello world");

        }
        //主动获取执行结果 超时等待1s退出
        BigDecimal aDouble = null;
        try {
            aDouble = submit.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(aDouble);
        executor.shutdown();

    }
}
