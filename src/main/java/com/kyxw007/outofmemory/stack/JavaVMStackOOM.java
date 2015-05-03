package com.kyxw007.outofmemory.stack;

/**
 * 创建太多线程导致的无法扩展栈是抛出OOM错误
 * －Xss2M
 *
 * Created by kyxw007 on 15/3/19.
 */
public class JavaVMStackOOM {
    private long threadNum;

    private void dontStop(){
        while (true){
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stackLeakByThread(){
        while (true) {
            threadNum++;
            System.out.println(threadNum);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        try{
            oom.stackLeakByThread();
        }catch (Throwable e){
            System.out.println("线程数：" + oom.threadNum);
            throw e;
        }
    }

}
