package com.kyxw007.多线程.threadsyn;

/**
 * Created by mac on 15/3/6.
 */
public class LockObject1 implements Runnable{
    private Object lock ;
    int threadid;
    LockObject1(int id,Object o){
        this.threadid = id;
        this.lock = o;
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
