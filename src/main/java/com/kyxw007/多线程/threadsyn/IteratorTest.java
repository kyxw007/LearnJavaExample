package com.kyxw007.多线程.threadsyn;

import java.util.*;

/**
 * Created by mac on 15/3/6.
 */
public class IteratorTest {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("haha");
        list.add("hehe");
        list.add("aiai");
        list.add("heihei");
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        tempMap.put("a", 1);
        tempMap.put("b", 2);
        tempMap.put("c", 3);

        Set<Map.Entry<String, Integer>> enset = tempMap.entrySet();
        Iterator<Map.Entry<String, Integer>> itrat = enset.iterator();
        while (itrat.hasNext()){
            Map.Entry<String, Integer> en = itrat.next();
            System.out.println(en.getKey()+" --- "+en.getValue());
        }

    }
}
