package com.kyxw007.memoryleak;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kyxw007 on 15/3/18.
 */
public class memorytest {
    public static void main(String[] args){
        leak1();
    }

    private  static void leak1(){
        List<String> v = new ArrayList<String>();
        for(int i=0;i<100;i++){
            String s = new String("yiyiyiyi");
            v.add(s);
            s = null;

        }

        for(String s:v){
            System.out.println("s:"+s);
        }
    }
}
