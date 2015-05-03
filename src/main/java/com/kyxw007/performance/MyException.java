package com.kyxw007.performance;

/**
 * Created by kyxw007 on 15/3/12.
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public Throwable fillInStackTrace() {
        //自建异常类，当不需要返回栈信息时使用
        return this;
    }
}
