package com.kyxw008.设计模式.decorator;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Main {
    public static void main(String[] args){
        Person jack = new Person();
        Jean decrator = new Jean(new Coat(jack));
        decrator.wareCloths();
    }
}
