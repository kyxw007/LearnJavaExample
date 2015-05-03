package com.kyxw007.多线程.lock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class TaskWithSync extends Task implements Runnable {
    @Override
    public void run() {
        synchronized ("A"){
            doSomething();
        }
    }
}
