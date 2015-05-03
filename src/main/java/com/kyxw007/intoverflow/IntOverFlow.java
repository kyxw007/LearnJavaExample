package com.kyxw007.intoverflow;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class IntOverFlow {
    public static void main(String[] args){
        int a = 0;
        int $c = 0;
        do
        {
            --$c;
            a = a - 1;
            System.out.println("a:" + a);
            System.out.println("c:" + $c);
        }
        while ( a > 0 );

    }
}
