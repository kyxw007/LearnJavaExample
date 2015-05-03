package com.kyxw007.排序sort.shell;

import com.kyxw007.排序sort.quick.QuickSort;

/**
 * Created by kyxw007 on 15/3/10.
 */
public class Main {
    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int data[] = {44,22,2,32,54,22,88,77,99,11};
        qs.setData(data);
        qs.sort(0, data.length-1);
        qs.display();
    }
}
