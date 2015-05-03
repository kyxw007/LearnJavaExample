package com.kyxw007.多线程.deadlock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Foo implements Runnable {
    @Override
    public void run() {
        fun(10);
    }

    public synchronized void fun(int i) {
        if (--i > 0) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(i);
            fun(i);
        }
    }




}
