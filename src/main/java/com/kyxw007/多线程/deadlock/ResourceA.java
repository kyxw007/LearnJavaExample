package com.kyxw007.多线程.deadlock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class ResourceA {
    public synchronized void a1(ResourceB b){
        String name = Thread.currentThread().getName();
        System.out.println(name+"进入A.a1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"等待B.b2");
        b.b2();
    }
    public synchronized void a2(){
        System.out.println("进入A.a2");
    }
}
