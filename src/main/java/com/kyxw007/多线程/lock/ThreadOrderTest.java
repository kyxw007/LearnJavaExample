package com.kyxw007.多线程.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kyxw007 on 15/4/12.
 */
public class ThreadOrderTest {
    //锁
    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new ThreadOrderTest().start();
    }

    public void start() throws InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new ThreadWithOrder(ThreadName.A));
        es.submit(new ThreadWithOrder(ThreadName.B));
        es.submit(new ThreadWithOrder(ThreadName.C));

        while (!lock.tryLock()) {
            System.out.println("等待锁释放~~");
        }

        try {
            System.out.println("获取锁");
            c.signal();
        } finally {
            lock.unlock();
            System.out.println("释放锁");
        }


    }


    //线程类型
    public static enum ThreadName {
        A("A"), B("B"), C("C");
        String value;

        ThreadName(String value) {
            this.value = value;
        }
    }

    //线程类
    class ThreadWithOrder implements Runnable {

        private ThreadName name;
        private int count = 11;

        //构造函数
        ThreadWithOrder(ThreadName name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("初始化~" + name.value);

            while (--count > 0) {
                lock.lock();
                try {
                    switch (name) {
                        case A:
                            c.await();
                            System.out.print(name.value);
                            a.signal();
                            break;
                        case B:
                            a.await();
                            System.out.print(name.value);
                            b.signal();

                            break;
                        case C:
                            b.await();
                            System.out.print(name.value);
                            c.signal();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
