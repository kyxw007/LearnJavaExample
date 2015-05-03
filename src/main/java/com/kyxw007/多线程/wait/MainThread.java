package com.kyxw007.多线程.wait;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class MainThread {
    private static Object obj = new Object();
    public static void main(String[] arg){
        new  MainThread().start();
    }

    public void start(){
        new Thread(new Wait()).start();
        new Thread(new Notify()).start();
    }

    /**
     * 等待线程
     */
    class Wait implements  Runnable{

        @Override
        public void run() {
            System.out.println("Wait 线程进入等等");
            try {
                synchronized (obj){
                    obj.wait();
                }
                System.out.println("Wait 醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 唤醒进程
     */
    class Notify implements Runnable{

        @Override
        public void run() {
            try {

                Thread.sleep(3000);
                System.out.println("Notify 唤醒 Wait");
                synchronized (obj){
                    obj.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
