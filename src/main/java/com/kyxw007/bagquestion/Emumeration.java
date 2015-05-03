package com.kyxw007.bagquestion;

/**
 * Created by kyxw007 on 15/3/20.
 */
public class Emumeration {

    public static void main(String[] args){

        Emumeration e = new Emumeration();
        System.out.println("递归算法结果");
        e.emumeRecur("", 4);
        System.out.println("非递归算法结果：");
        e.emumeNotRecur(4);
    }
    public void emumeNotRecur(int a){
        int[] flag = new int[a];

        while(true){
            for (int i = 0 ;i<a;i++){

            }
        }

    }

    public void emumeRecur(String b ,int a){
        if(a == 0){
            System.out.println(b);
        }else {
            emumeRecur(b + " 0", a - 1);
            emumeRecur(b+" 1",a-1);
        }
    }

}
