package com.kyxw008.设计模式.decorator;

import java.net.HttpURLConnection;

/**
 * Created by kyxw007 on 15/5/3.
 */
public class Decorator implements Human {
    private Human human;
    @Override
    public void wareCloths() {
        human.wareCloths();
    }

    @Override
    public void walk() {
        human.walk();
    }

    public void setHuman(Human human){
        this.human = human;
    }
}
