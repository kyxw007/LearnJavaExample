package com.kyxw008.设计模式.decorator;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Jean extends Decorator {

    public Jean(Human human) {
        super(human);
    }
    public void wareJeans(){
        System.out.println("穿牛仔裤");
    }


    @Override
    public void wareCloths() {
        super.wareCloths();
        wareJeans();
    }

}
