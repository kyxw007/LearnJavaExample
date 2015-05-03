package com.kyxw007.多线程.deadlock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class ResourceB {
    public  synchronized void b1(ResourceA a) {
        String name = Thread.currentThread().getName();
        System.out.println(name+"进入B.b1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"等待A.a2");
        a.a2();
    }

    public synchronized void b2(){
        System.out.println("进入B.b2");
    }
}
