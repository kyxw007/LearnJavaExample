package com.kyxw008.设计模式.decorator;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Jack implements Human {
    @Override
    public void wareCloths() {
        System.out.println("穿什么好啊～");
    }

    @Override
    public void walk() {
        System.out.println("去哪儿好啊～");
    }
}
