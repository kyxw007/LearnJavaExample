package com.kyxw007.多线程.threadsyn;

/**
 * Created by mac on 15/3/6.
 */
public class LockObjectRunable implements Runnable{
    private static Object lock = new Object();
    int threadid;
    LockObjectRunable(int id){
        this.threadid = id;

    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i=0;i<100;i++){
                 System.out.println("thread "+threadid+"is running in "+i+"times");
            }

        }
    }
}
