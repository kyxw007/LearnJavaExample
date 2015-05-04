package com.kyxw008.设计模式.proxy;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Persuitor implements BuyGifts{
    private SchoolGirl schoolGirl;
    public Persuitor(SchoolGirl sg) {
        this.schoolGirl = sg;
    }


    @Override
    public void giveFlowers() {
        System.out.println("代理送花");
    }

    @Override
    public void giveToys() {
        System.out.println("代理送玩具");
    }
}
