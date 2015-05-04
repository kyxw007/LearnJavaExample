package com.kyxw008.设计模式.factory;

import com.sun.tools.javac.code.Scope;

/**
 * Created by kyxw007 on 15/5/4.
 */
public class Main {
    public static void main(String[] args){
        FactoryA fa = new FactoryA();
        Product pa = fa.creatProduct();
        pa.print();
        FactoryB fb = new FactoryB();
        Product pb = fb.creatProduct();
        pb.print();
    }
}
