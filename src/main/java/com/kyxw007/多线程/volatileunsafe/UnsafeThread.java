package com.kyxw007.多线程.volatileunsafe;

/**
 * Created by mac on 15/3/9.
 */
public class UnsafeThread implements Runnable {
    private volatile int count = 0;

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            Math.hypot(Math.pow(92456789,i),Math.cos(i));
        }
        count++;
    }

    public  int getCount(){
        return count;
    }
}
