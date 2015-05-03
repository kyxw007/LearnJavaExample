package com.kyxw007.多线程.threadsyn;

/**
 * Created by mac on 15/3/6.
 */
public class ThreadSyn {
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
//            new Thread(new TestRunable(i)).start();
//            new Thread(new LockObjectRunable(i)).start();
//            new Thread(new SynMethon(i)).start();
            new Thread(new LockObject1(i,lock)).start();
        }
    }
}
