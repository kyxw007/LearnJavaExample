package com.比赛;

import java.util.ArrayList;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class MyList implements IList {
    private ArrayList<Object> list ;

    MyList(){
        list = new ArrayList<Object>();
    }
    @Override
    public void add(Object elem) {
        list.add(elem);
    }

    @Override
    public Object get(int index) {
        if(index>=list.size()){
            throw new IndexOutOfBoundsException();
        }

        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {

    }
}
