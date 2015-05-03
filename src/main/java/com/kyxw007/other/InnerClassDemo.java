package com.kyxw007.other;

/**
 * Created by kyxw007 on 15/4/7.
 * 内部类
 */
public class InnerClassDemo {
    public static void main(String[] args){

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

    }

}

class Outer{
    static int staicMember;
    int notStaticMember;

    static void staticMethod(){
        final int a = 0;//必须加final才可以被
        class InnerInStaticMethod{
            void method(){
                int b=a;
            }
        }
    }

    static class StaticNested{
        public void method(){
            staicMember=0;
//          notStaticMember = 100; 不可以访问非静态成员
        }
    }

    class Inner{

    }
}
