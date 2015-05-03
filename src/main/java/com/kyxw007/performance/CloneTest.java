package com.kyxw007.performance;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class CloneTest {

    private static class Apple implements Cloneable{
        public Object clone(){
            try{
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new Error();
            }
        }
    }

    public static void main(String[] args){
        final int maxLoops = 10*10000;
        int loops = 0 ;
        long start = System.nanoTime();
        Apple apple = new Apple();
        while (++loops<maxLoops){
            apple.clone();
        }
        long mid = System.nanoTime();
        System.out.println("克隆用时："+(mid-start));
        while (--loops>0){
            new Apple();
        }
        long end = System.nanoTime();
        System.out.println("new用时："+(end-mid));
    }
}
