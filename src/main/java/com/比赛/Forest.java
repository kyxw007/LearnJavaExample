package com.比赛;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by kyxw007 on 15/4/11.
 */
public class Forest implements Serializable {
    private Tree tree = new Tree();
    public static void main(String[] args) {
        Forest f = new Forest();
        try {
            FileOutputStream fs = new FileOutputStream("Forest.Ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(f);
            os.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
class Tree implements Serializable{}
