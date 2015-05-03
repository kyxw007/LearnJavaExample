package com.kyxw008.algrithm;

import java.util.*;

/**
 * Created by kyxw007 on 15/4/2.
 */
public class random900 {
    public static  void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random random = new Random();
        while (map.size()!=900){
            int a=random.nextInt(1000);
            if(map.containsKey(a)){
                continue;
            }else{
                map.put(a,0);
            }

        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> entry:entrySet){
            System.out.println(entry.getKey());
        }


    }
}
