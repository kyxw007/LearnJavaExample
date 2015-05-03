package com.kyxw007.tryDemo;

/**
 * Created by kyxw007 on 15/4/7.
 */
public class ReturnIntry {
    public static void main(String[] args){
        System.out.println(new ReturnIntry().testReturnInTry());
    }

    public int testReturnInTry(){
        int a = 123;
        try{
            return a;
        }catch (Throwable e){

        }finally {
            a = 3333;
            System.out.println(" still runing "+a++);
            return a;
        }
    }
}
