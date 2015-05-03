package com.kyxw008.algrithm;

import java.util.*;


/**
 * Created by kyxw007 on 15/4/2.
 */
public class AppleQuestion {

    private ArrayList<Apple> basket = new ArrayList<Apple>();//苹果篮子
    public static void main(String[] args){
        AppleQuestion q = new AppleQuestion();
        q.start();
    }

    /**
     * 开始模拟
     */
    public void start(){
        new Thread(new ManPut()).start();
        new Thread(new ManTake()).start();
    }
    /**
     * 同步方法：true 是放，false是拿
     */
    private synchronized void putOrtake(boolean flag){
        if(flag){
            if(basket.size()<5){
                System.out.println("拿苹果");
                basket.add(new Apple(new Date()));

            }
        }else{
            if (basket.size()>0){
                System.out.println("放苹果");
                basket.remove(basket.remove(0));
            }
        }
    }
    /**
     * 拿苹果的人
     */
    private class ManTake implements Runnable{

        @Override
        public void run() {
            while (true){
                putOrtake(false);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 放苹果的人
     */
    private class ManPut implements Runnable{
        @Override
        public void run() {
            while (true){
                putOrtake(true);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //苹果
    private class Apple{
        private Date date;
        Apple(Date _date){
            this.date=_date;
        }
    }
}

