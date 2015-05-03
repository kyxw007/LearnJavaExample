package com.kyxw007.多线程.countdown;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Runner implements Callable<Integer> {
    private CountDownLatch begin;
    private CountDownLatch end;
    public Runner(CountDownLatch _begin ,CountDownLatch _end){
        this.begin = _begin;
        this.end = _end;
    }
    @Override
    public Integer call() throws Exception {
        int score = new Random().nextInt(25);
        begin.await();
        TimeUnit.MILLISECONDS.sleep(score);
        end.countDown();
        return score;
    }

}
