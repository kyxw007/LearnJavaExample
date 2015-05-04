package com.kyxw008.设计模式.decorator;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Coat extends Decorator {
    public Coat(Human human) {
        super(human);
    }

    private void wareCoat(){
        System.out.println("穿大衣～");
    }

    @Override
    public void wareCloths() {
        super.wareCloths();
        wareCoat();
    }
}
