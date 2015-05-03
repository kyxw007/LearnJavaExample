package com.kyxw008.设计模式.obsever;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class ObseverDinner{
    public static void main(String[] args){
        Dinner dinner = new Dinner();
        Mon mon = new Mon();
        mon.addNotifyer(new Me());
        mon.addNotifyer(new Sister());
        dinner.addObserver(mon);
        dinner.hasChanged();
        dinner.notifyObservers();
        dinner.dinnerOK();
    }
}
