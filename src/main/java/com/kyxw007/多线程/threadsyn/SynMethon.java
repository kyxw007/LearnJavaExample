package com.kyxw007.多线程.threadsyn;

/**
 * Created by mac on 15/3/6.
 */
public class SynMethon implements Runnable {

    private int threadId;

    public SynMethon(int id){
        this.threadId = id;
    }

    @Override
    public void run() {
        threadTask(threadId);
    }

    private static synchronized void threadTask(int id){
        for(int i=0;i<100;i++){
            System.out.println("thread "+id+"is running in "+i+"times");
        }

    }
}
