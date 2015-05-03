package com.kyxw007.runtime;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class RuntimeTest {
    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();
        int processorNum = runtime.availableProcessors();
        System.out.println("处理器树："+processorNum);
        long memory = runtime.totalMemory();
        System.out.println("总内存："+memory+" B");
        System.out.println("初始可用内存："+runtime.freeMemory() +" B");
        List<Double> list = new LinkedList<Double>();
        Random random = new Random();
        double[] array = new double[10000];
        for(int i = 0 ;i<10000;i++){

            list.add(random.nextDouble());
            array[i]=random.nextDouble();
        }

        System.out.println("新建列表后，可用内存："+runtime.freeMemory() +" B");
        runtime.gc();
        System.out.println("调用gc后，可用内存："+runtime.freeMemory());
    }

}
