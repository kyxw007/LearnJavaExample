package com.kyxw007.other;

import java.util.Date;

/**
 * Created by kyxw007 on 15/4/7.
 */
public class GetClassDemo  {
    public static void main(String[] args){
        new GetClassDemo().print();
    }
    public void print(){
        System.out.println(new Test().getClass().getName());
        System.out.println(new Test().getClass().getSuperclass().getName());
    }
    class Test extends Date{

    }
}
