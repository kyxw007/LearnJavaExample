package com.kyxw007.outofmemory.stack;

/**
 *
 * 虚拟机栈深不够导致的内存溢出
 * vm args -Xss 128k //分配虚拟机栈内存为128k
 *
 * Created by kyxw007 on 15/3/19.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();

    }

    public static void main(String[] args) throws Throwable {

        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("栈深：" + oom.stackLength);
            throw e;
        }


    }
}
