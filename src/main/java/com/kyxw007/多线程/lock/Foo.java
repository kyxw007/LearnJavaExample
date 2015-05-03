package com.kyxw007.多线程.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Foo {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();
    public void read(){
        try{
            r.lock();
            Thread.sleep(1000);
            System.out.println("reading ......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            r.unlock();
        }
    }

    public void write(){
        try{
            w.lock();
            Thread.sleep(1000);
            System.out.println("writing ......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            w.unlock();
        }
    }
}
