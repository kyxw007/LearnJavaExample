package com.kyxw008.设计模式.obsever;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class Sister implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("妹妹：知道饭好了");
    }
}
