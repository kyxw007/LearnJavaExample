package com.kyxw007.stringdemo;

import java.util.StringTokenizer;

/**
 * Created by kyxw007 on 15/4/7.
 */
public class InitDemo {
    public static void main(String[] args){
        new InitDemo().testEqual();
    }

    private void testEqual(){
        System.out.println(new String("abc").equals(new String("abc")));//true
        System.out.println("abc".equals("abc"));//true
        System.out.println(new String("abc").equals("abc"));//true
        System.out.println("abc"=="abc");//true
        System.out.println(new String("abc")=="abc");//false
        System.out.println(new String("abc") == new String("abc"));//false
        System.out.println(new StringBuffer("abc").equals(new StringBuffer("abc")));//false 没有实现equals方法

        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        System.out.println(s2 == "ab");//false
        System.out.println(s2.equals("ab"));//true
        System.out.println(s3 == "ab");//true
        s2.intern();
        System.out.println(s2 == "ab");


    }
    private void splitString(){
        String orgStr = "as,2131,45,sad,34,dsa,weq";
        StringTokenizer tokener = new StringTokenizer(orgStr,",");
        String[] result =  new String[tokener.countTokens()];
        int i = 0;
        while (tokener.hasMoreTokens()){
            result[i++] = tokener.nextToken();
        }
        for (String a:result){
            System.out.println(a);
        }
    }
}
