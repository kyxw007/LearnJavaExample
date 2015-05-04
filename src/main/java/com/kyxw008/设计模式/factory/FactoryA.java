package com.kyxw008.设计模式.factory;

/**
 * Created by kyxw007 on 15/5/4.
 */
public class FactoryA implements Factory {
    @Override
    public Product creatProduct() {
        return new ProductA();
    }
}
