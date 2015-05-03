package com.kyxw008.rpcorder;

import com.kyxw008.rpcorder.RemoteHandler;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * Created by kyxw007 on 15/4/4.
 */
public class RPCTest extends TestCase {

    public void testHandler1(){
        int[] case1 = {1,2,5,8,10,4,3,6,9,7};
        int[] case2 = {1,2,3,4,5,6,7,8,9,10};
        int[] case3 = {10,9,8,7,6,5,4,3,2,1};
        RemoteHandler rh = new RemoteHandler();
        rh.reset();
        for (int i:case1){
            rh.handle(i);
        }
        Assert.assertTrue(isRightOrder(rh.getDoneList()));
        rh.reset();
        for (int i:case2){
            rh.handle(i);
        }
        Assert.assertTrue(isRightOrder(rh.getDoneList()));
        rh.reset();
        for (int i:case3){
            rh.handle(i);
        }
        Assert.assertTrue(isRightOrder(rh.getDoneList()));

    }

    private boolean isRightOrder(List<Integer> list){
        for (int i=0;i<list.size();i++){
            if (list.get(i)!=(i+1)){
                return false;
            }
        }
        return true;
    }

}
