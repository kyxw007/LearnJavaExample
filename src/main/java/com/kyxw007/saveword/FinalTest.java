package com.kyxw007.saveword;

/**
 * Created by kyxw007 on 15/4/7.
 * 静态变量可以多次赋值
 *
 *
 */
public class FinalTest {
    public static  int i =0;
    public static void main(String[] args){
        FinalTest.i = 121;
        System.out.print(FinalTest.i);
        FinalTest.i = 123121;
        System.out.print(FinalTest.i);
    }
}
