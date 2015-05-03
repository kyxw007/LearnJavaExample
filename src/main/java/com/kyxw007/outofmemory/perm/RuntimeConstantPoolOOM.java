package com.kyxw007.outofmemory.perm;

import java.util.ArrayList;

/**
 *
 * VM args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by kyxw007 on 15/3/19.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        int i =0;
        while (true){
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }

}
