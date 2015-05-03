package com.比赛;

import java.util.*;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        MainTest a = new MainTest();
//        aa();
        String[] elements = { "for", "tea", "too" };
        String first = (elements.length > 0 ) ? elements[0] : null;
        System.out.print(first);
    }
    public static void fun (short n) { System.out.print("short "); }
    public static void fun (Short n) { System.out.print("SHORT "); }
    public static void fun (Long n) { System.out.print("LONG "); }
    enum Num {ONE, THREE, TWO}
    public static void aa() {
        Collection coll = new ArrayList();
        coll.add(Num.ONE);


        coll.add(Num.THREE);

        coll.add(Num.THREE);

        coll.add(Num.TWO);
        coll.add(Num.TWO);

        Set set = new HashSet(coll);
        System.out.println(set);
    }

    class runing implements Runnable{

        @Override
        public void run() {

        }
        void waitForSignal() {
            Object obj = new Object();
            synchronized (Thread.currentThread()) {


                obj.notify();

            }
        }
    }



}
class ComplexCalc {
    public int value;
    public void calc() { value += 5; }
}

class MoreComplexCalc extends ComplexCalc {
    public void calc() { value -= 2; }
    public void calc(int multi) {
        calc();
        super.calc();
        value *= multi;
    }

}
abstract class Shape {
    /**
     * 计算形状的面积
     */
    abstract public int getArea();
}

class Rectangle extends Shape{
    private int width;
    private int height;
    @Override
    public int getArea(){
        return width*height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}