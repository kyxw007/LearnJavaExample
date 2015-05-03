package com.kyxw007.多线程.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Worker implements Runnable {
    private CyclicBarrier cb;
    public Worker(CyclicBarrier _cb){
        this.cb = _cb;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName()+"-到达汇合点");
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
