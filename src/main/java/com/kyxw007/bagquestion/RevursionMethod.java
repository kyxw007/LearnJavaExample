package com.kyxw007.bagquestion;

/**
 * Created by kyxw007 on 15/3/18.
 */
public class RevursionMethod {
    static int stuffNum = 7;
    static int bagContainNum = 20;
    static int[] stuffArray = {1, 4, 3, 4, 5, 2, 7,0};
    public static void main(String[] args){
        knap(bagContainNum,stuffNum);

    }


    private  static  boolean knap(int s1,int n){
        if(s1==0){
            return true;
        }
        if (s1<0||(s1>0&&n<1)){
            return false;
        }

        if(knap(s1-stuffArray[n],n-1)){
            System.out.println(stuffArray[n] );
            return true;
        };

        return knap(s1,n-1);
    }

}
