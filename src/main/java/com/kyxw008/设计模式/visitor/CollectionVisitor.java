package com.kyxw008.设计模式.visitor;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class CollectionVisitor implements Visitor {
    @Override
    public void visitString(VisitableString visitableString) {
        System.out.println("visit String : " + visitableString.getValue());
    }

    @Override
    public void visitFloat(VisitableFloat visitableFloat) {
        System.out.println("visit Float : " + visitableFloat.getValue());
    }
    @Override
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            if (o instanceof Visitable){
                ((Visitable)o).accept(this);
            }
        }
    }


}
