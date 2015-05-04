package com.kyxw008.设计模式.simplefactory;

/**
 * Created by kyxw007 on 15/5/4.
 */
public class SimpleFactory {
    public static Product createProduct(String product){
        switch (product){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return new Product() {
                    @Override
                    public void printProductName() {
                        System.out.println("nothing ");
                    }
                };
        }
    }
}
