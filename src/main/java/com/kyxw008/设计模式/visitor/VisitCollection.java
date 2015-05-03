package com.kyxw008.设计模式.visitor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class VisitCollection {
    public static void main(String[] args){
        Visitor visitor = new CollectionVisitor();

        VisitableString stringE = new VisitableString("I am a String");
        visitor.visitString(stringE);

        Collection list = new ArrayList();
        list.add(new VisitableString("I am a String1"));
        list.add(new VisitableString("I am a String2"));
        list.add(new VisitableFloat(new Float(12)));
        list.add(new VisitableString("I am a String3"));
        visitor.visitCollection(list);


    }
}
