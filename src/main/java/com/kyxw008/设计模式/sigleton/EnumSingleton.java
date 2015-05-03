package com.kyxw008.设计模式.sigleton;

/**
 * Created by kyxw007 on 15/4/8.
 */
public class EnumSingleton {
    public static void main(String[] args){
        Singleton.uniqueInstance.instanceMethod();
        Singleton.dshi.instanceMethod();
    }
}

enum Singleton{
    uniqueInstance,dshi;
    public void instanceMethod(){
        System.out.print("haahha");
    }
}
