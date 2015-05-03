package com.kyxw007.saveword;

/**
 * Created by kyxw007 on 15/4/7.
 */
public class SuperDemo {
    public static void main(String[] args)
    {
        System.out.print(new B().getA());
    }
}

class A{
    private int a=12;
    public int getA(){
        return a;
    }

}

class B extends A{
    public int getA(){
        int a = super.getA();
        return a;
    }
}
