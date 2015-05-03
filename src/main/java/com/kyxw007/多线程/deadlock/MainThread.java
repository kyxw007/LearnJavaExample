package com.kyxw007.多线程.deadlock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class MainThread {
    public static void main(String[] args){
        run3();
    }
    public  static void run3(){
        final ResourceA a = new ResourceA();
        final ResourceB b = new ResourceB();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a1(b);
            }
        },"线程A ").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b1(a);
            }
        },"线程B ").start();



    }

    public static void run2(){
        final Foo1 foo = new Foo1();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.m1();
            }
        });
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foo.m2();

    }
    public static void run1(){
        new Thread(new Foo()).start();
    }

}
