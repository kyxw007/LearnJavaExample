package com.kyxw007.performance;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class MainTest {
    public static void main(String[] args){
        exceptionTest();
    }

    private static void exceptionTest(){

        long t1 = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            try {
                throw  new MyException("yoyo");
            }catch (Throwable e) {

            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("take time : "+(t2-t1));
    }
}
