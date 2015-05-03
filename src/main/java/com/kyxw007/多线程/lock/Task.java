package com.kyxw007.多线程.lock;

import java.util.Calendar;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class Task {
    public void doSomething(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        sb.append("线程名称："+Thread.currentThread().getName());
        sb.append(",运行时间："+ Calendar.getInstance().get(13)+"s");
        System.out.println(sb);
    }
}
