package com.kyxw007.多线程.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kyxw007 on 15/3/9.
 */
public class TaxCalculator implements Callable<Integer>{
    private int seedMoney;
    public TaxCalculator(int _seedMoney){
        this.seedMoney = _seedMoney;
    }
    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10000);
        return this.seedMoney/10;
    }
}
