package com.kyxw007.多线程.threadsyn;

/**
 * Created by mac on 15/3/6.
 */
public class TestRunable implements Runnable{
    int threadid;
    TestRunable(int id){
        this.threadid = id;
    }
    @Override
    public synchronized void run() {
        for (int i=0;i<100;i++){
            System.out.println("thread is runing , threadid is :"+this.threadid);
        }

    }
}
