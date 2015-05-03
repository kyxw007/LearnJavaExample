package com.kyxw008.algrithm;

/**
 * Created by kyxw007 on 15/4/8.
 *
 根据上排给出十个数，在其下排填出对应的十个数
 要求下排每个数都是先前上排那十个数在下排出现的次数。
 上排的十个数如下：【0，1，2，3，4，5，6，7，8，9】

 举个例子，
 上排数值: 0,1,2,3,4,5,6,7,8,9
 下排数值: 6,2,1,0,0,0,1,0,0,0
 0在下排出现了6次，1在下排出现了2次，
 2在下排出现了1次，3在下排出现了0次....


 */
public class NumberTimes {
    private boolean isSuccess = false;
    private int[] a = new int[10];
    private int[] b = new int[10];
    public static void main(String[] args){
        NumberTimes nt = new NumberTimes();
        nt.init();
        nt.getB();
    }

    private void init(){
        for (int i = 0;i<10;i++){
            a[i]=i;
            b[i]=i;
        }
    }

    public void getB(){
        while (!isSuccess){
            reflashBottom();
        }
        print();
    }

    private void print(){
        for (int i=0;i<b.length;i++){
            System.out.print(b[i] + " ");
        }
        System.out.print("\n");
    }

    private void reflashBottom() {
        boolean flag = true;
        for (int i=0;i<b.length;i++){
            int count = cout(a[i]);
            if (b[i]!=count){
                b[i]=count;
                flag = false;
            }
        }
        if (flag)
            isSuccess = true;
        print();
    }

    private int cout(int ai){
        int count = 0;
        for (int i=0;i<b.length;i++){
            if (b[i]==ai)
                count++;
        }
        return count;
    }

}
