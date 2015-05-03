package com.kyxw007.bagquestion;

/**
 * Created by kyxw007 on 15/3/18.
 */
public class UnRecursionMethod {

    static int stuffNum = 7;
    static int bagContainNum = 20;
    static int[] stuffArray = {1, 4, 3, 4, 5, 2, 7,0};
    static int[] flag = {0,0,0,0,0,0,0};

    public static void main(String[] args){
        knap(bagContainNum,stuffNum);

    }
    private static void knap(int s1,int n){
        int count = 0;
        int allcount = 1;
        for(int i = 0;i<stuffNum;i++){
            allcount = allcount*2;
        }

        while(true){
            count++;
            for(int i = 0;i<stuffNum;i++){
                if(flag[i]==0){
                    flag[i]=1;
                    continue;
                }else {
                    flag[i]=0;
                    break;
                }

            }
            for (int i=0; i<stuffNum;i++){
                System.out.print(flag[i]+" ");
            }
            System.out.print("\n");

            if ( count == allcount){
                break;
            }

        }
    }
}
