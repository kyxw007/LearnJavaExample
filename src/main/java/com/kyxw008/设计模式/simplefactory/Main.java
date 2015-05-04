package com.kyxw008.设计模式.simplefactory;

/**
 * Created by kyxw007 on 15/5/4.
 */
public class Main {
    public static void main(String[] args){
        Product a = SimpleFactory.createProduct("A");
        Product b = SimpleFactory.createProduct("B");
        a.printProductName();
        b.printProductName();
    }
}
