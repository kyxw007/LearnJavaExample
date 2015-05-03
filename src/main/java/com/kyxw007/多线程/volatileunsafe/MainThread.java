package com.kyxw007.多线程.volatileunsafe;

/**
 * Created by mac on 15/3/9.
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        int value = 1000;
        int loops = 0;
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        System.out.println("first active num :" + tg.activeCount());


        while (loops++ < value) {
            UnsafeThread ut = new UnsafeThread();
            for (int i = 0; i < value; i++) {
                new Thread(ut).start();
            }
            do {
                Thread.sleep(15);
            } while (tg.activeCount() != 2);
            if (ut.getCount() != value) {
                System.out.println("循环到第" + loops + "遍，出现线程不安全情况");
                System.out.println("此时的count ＝ " + ut.getCount());
            }


        }

    }

}
