package com.kyxw007.多线程.lock;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class LockAndCondition {
    private static Lock lock = new ReentrantLock();
    //绑定容器满条件
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList(12);
        Product product = new Product(list, 10);
        Consumer consumer = new Consumer(list, 0);

        Thread t1 = new Thread(product);
        Thread t2 = new Thread(consumer);

        t1.start();
        Thread.sleep(100);
        t2.start();

    }

    static class Product implements Runnable {

        private List list;
        private int maxCount;

        Product(List _list, int _maxCount) {
            super();
            list = _list;
            maxCount = _maxCount;
        }

        @Override
        public void run() {
            while (true) {
                if (lock.tryLock()) {
                    try {

                        if (getSize() >= maxCount) {
                            System.out.println("容器满...");
                            full.await();

                        }
                        System.out.println("开始生产 "+getSize());
                        list.add(new Object());
                        empty.signal();
                       Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                } else {
                   // System.out.println("无法获取生产权限");
                }

            }

        }

        public int getSize() {
            return list.size();
        }
    }

    static class Consumer implements Runnable {

        private List list;
        private int minCount;

        public Consumer(List list, int minCount) {
            super();
            this.list = list;
            this.minCount = minCount;
        }

        @Override
        public void run() {
            while (true) {
                if (lock.tryLock()) {
                    try {
                        if (getSize() <= minCount) {
                            System.out.println("容器空...");
                            empty.await();

                        }
                        System.out.println("开始消费-"+getSize());
                        list.remove(0);
                        full.signal();
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                } else {
                   // System.out.println("无法获得消费权限");
                }
            }

        }

        public int getSize() {
            return list.size();
        }
    }

}
