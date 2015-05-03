package com.kyxw007.多线程.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class ConditionTest {
    public static void main(String[] args) {
        ConditionTest conditiontest = new ConditionTest();
        conditiontest.start();
    }

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private void start() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.submit(new AwaitThread(i));
        }

        new Thread(new SignalThread()).start();
    }

    class AwaitThread implements Runnable {
        private int threadId;

        AwaitThread(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("init thread "+threadId);
                if (lock.tryLock()) {
                    try {
                        System.out.println("get lock"+threadId);
                        condition.await();
                        System.out.println("await - " + threadId);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                } else {

                }

            }

        }
    }

    class SignalThread implements Runnable {

//        SignalThread(Condition condition){
//            this.condition = condition;
//        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock.tryLock()) {
                    try {
                        Thread.sleep(10);
                        System.out.println("signal");
                        condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                } else {

                }
            }
        }
    }

}

