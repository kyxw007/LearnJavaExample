package com.kyxw007.多线程.countdown;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Race {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num = 10;
        CountDownLatch bengin = new CountDownLatch(2);
        CountDownLatch end = new CountDownLatch(num);
        ExecutorService es = Executors.newFixedThreadPool(num);
        ArrayList<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        for(int i=0;i<num;i++){
            futures.add(es.submit(new Runner(bengin,end)));
        }
        bengin.countDown();
        bengin.countDown();
        end.await();
        int count = 0;
        for(Future<Integer> f:futures){
            count+=f.get();
        }
        System.out.println("平均分数："+count/num);
        es.shutdown();
    }
}
