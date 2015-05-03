package com.kyxw007.排序sort.shell;

/**
 * Created by kyxw007 on 15/3/10.
 */
public class ShellSort {
    public static void main(String[] args){
        int[] a = {1,3,89,12,5,15,32,77,2};
        double d1 = a.length;
        int tem = 0;
        while (true){
            d1 = Math.ceil(d1/2);
            int d = (int)d1;
            for(int x = 0 ;x<d1;x++){
                //插入排序部分
                for(int i=x+d;i<a.length;i+=d){
                    int j = i-d;
                    tem = a[i];
                    for(;j>=0&&tem<a[j];j-=d){
                        a[j+d]=a[j];
                    }
                    a[j+d] = tem;
                }

            }
            if(d==1) break;
        }

        for(int a1:a){
            System.out.println(a1);
        }

    }
}
