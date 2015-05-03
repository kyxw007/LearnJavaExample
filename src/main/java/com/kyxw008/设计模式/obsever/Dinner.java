package com.kyxw008.设计模式.obsever;


import java.util.Observable;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class Dinner extends Observable {
    Dinner(){
        System.out.println("饭：开始煮饭~");
    }
    public void dinnerOK(){
        System.out.println("饭：晚饭好了~");
        System.out.println("饭：通知 "+this.countObservers()+" 个家里人！");
        setChanged();
        notifyObservers(1);
    }

}
