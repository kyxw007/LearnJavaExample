package com.kyxw008.设计模式.obsever;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class Mon implements Observer {
    Vector<Observer> notifyers = new Vector<Observer>();
    Observable observable;

    public void addNotifyer(Observer o){
        notifyers.add(o);
    }

    private void notifyThem(){
        System.out.println("妈妈：通知妹妹和我！");
        for (Observer o:notifyers){
            o.update(observable,1);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        observable = o;
        System.out.println("妈妈：知道饭好了！");
        notifyThem();
    }
}
