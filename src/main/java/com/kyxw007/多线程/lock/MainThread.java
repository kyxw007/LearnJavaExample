package com.kyxw007.多线程.lock;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class MainThread {
    public static void main(String[] args){
        run2();

    }

    public static void run2(){
        final Lock lock = new ReentrantLock();
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        try {
                            Thread.sleep(2000);
                            StringBuffer sb = new StringBuffer();
                            sb.append("线程名称："+Thread.currentThread().getName());
                            sb.append(",运行时间："+ Calendar.getInstance().get(13)+"s");
                            System.out.println(sb);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }



    public static void run1(){
        try {
            runTask(TaskWithLock.class);
            runTask(TaskWithSync.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void runTask(Class <?extends Runnable> clz) throws IllegalAccessException, InstantiationException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("开始执行任务---"+clz.getName());
        for(int i= 0;i<3;i++){
            es.submit(clz.newInstance());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("执行完毕");
        es.shutdown();
    }
}
