package com.kyxw007.多线程.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class MainWork {
    public static void main(String[] args) {
        int workerNum = 3000;
        final ExecutorService es = Executors.newFixedThreadPool(workerNum + 1);

        CyclicBarrier cb = new CyclicBarrier(workerNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已经打通啦！");
                es.shutdown();

            }
        });
        for (int i = 0; i < workerNum; i++) {
            es.submit(new Worker(cb));
        }

    }
}
