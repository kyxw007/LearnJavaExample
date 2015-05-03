package com.kyxw007.多线程.callable;

import java.util.concurrent.*;

/**
 * Created by kyxw007 on 15/3/9.
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(new TaxCalculator(100));
        while (!future.isDone()){
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("#");
        }
        System.out.println("\n 计算完成，结果是："+future.get()+"元");
        es.shutdown();
    }
}
