package com.kyxw007.多线程.deadlock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Foo1 {

    public synchronized void m1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 执行完毕");

    }
    public synchronized void m2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 执行完毕");
    }
}
