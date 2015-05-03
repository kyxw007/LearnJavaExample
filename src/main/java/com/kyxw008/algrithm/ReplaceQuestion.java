package com.kyxw008.algrithm;

import java.util.Random;

/**
 * 有0-999的数字，乱序放进一个长度为1000的数组里，随机用两个不是0-999的数替换掉其中的两个数；找出被替换的两个数。

 * Created by kyxw007 on 15/3/31.
 */
public class ReplaceQuestion {
    private int[] arr = new int[1000];

    public static  void main(String[] args){
        ReplaceQuestion rq = new ReplaceQuestion();
        rq.createArray();
        rq.find1();
    }
    public void find1(){
        int sum = sumArr();//两个被替代数之和
        int qsum = qsumArr();//被替代数平方和
        System.out.println(sum);
        System.out.println(qsum);
        getRoot(sum,qsum);//求解方程

    }

    private int getRoot(int sum,int qsum){
        float delta= (float) Math.sqrt(4*sum*sum - 8*(sum*sum - qsum));
        int root1 = (int) ((2*sum + delta)/4);
        int root2 = (int) ((2*sum - delta)/4);
        System.out.println("roots:"+root1+","+root2);

        return 0;
    }

    private int qsumArr(){
        int sum = 0;
        int j=0;
        for (int i:arr){
            sum += j*j;
            j++;
            if(i>=0&&i<1000){
                sum -= i*i;
            }
        }
        return sum;
    }

    private int sumArr(){
        int sum = 0;
        int j=0;
        for (int i:arr){
            sum += j;
            j++;
            if(i>=0&&i<1000){
                sum-=i;
            }
        }
        return sum;
    }

    /**
     *  产生数组
     */
    public void createArray(){
        for(int i=0;i<1000;i++) arr[i]=i;
        Random random = new Random();
        int replaceposition1 = random.nextInt(1000);
        int replaceposition2=0;
        while ((replaceposition2=random.nextInt(1000))==replaceposition1){

        }
        arr[replaceposition1]=101010;
        arr[replaceposition2]=101101;
        System.out.println("replace:"+replaceposition1+","+replaceposition2);
        for (int i=0;i<1000;i++){
            int swap = random.nextInt(1000);
            int temp = arr[i];
            arr[i] = arr[swap];
            arr[swap] = temp;
        }
    }
}
