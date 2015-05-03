package com.kyxw007.多线程.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class TaskWithLock extends Task implements Runnable {
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try{

        lock.lock();
        doSomething();
    }finally {
        lock.unlock();
    }
    }
}
