package com.比赛;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class MySudo implements Sudo {
    public  void crazy(String s){}
    public static void main(String[] args) {
        MySudo test = new MySudo();
        int a = test.a++;
        int b = test.b--;
        int c = test.c++;
        int d = test.d--;
        System.out.println(a + " - " + b + " - " + c + " - " + d);
    }
    private int a;
    public int b;
    protected int c;
    int d;
}
