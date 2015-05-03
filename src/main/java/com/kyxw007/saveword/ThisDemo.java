package com.kyxw007.saveword;

/**
 * Created by kyxw007 on 15/4/7.
 *
 * 测试this
 */
public class ThisDemo {
    int number;
    public ThisDemo createInstance(){
        number++;
        return this;
    }
    public ThisDemo(){
        number++;
    }

    public  ThisDemo(int _number){
        this();
        number+=_number;
    }

    private void print(){
        System.out.println(number);
    }

    public static void main(String[] args){
        ThisDemo td = new ThisDemo(10);
        td.print();
        td.createInstance().createInstance().createInstance().print();


    }
}
