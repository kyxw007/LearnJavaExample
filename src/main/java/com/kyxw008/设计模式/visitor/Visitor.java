package com.kyxw008.设计模式.visitor;

import java.util.Collection;

/**
 * Created by kyxw007 on 15/3/21.
 */
public interface  Visitor {
    public void visitString(VisitableString visitableString);
    public void visitFloat(VisitableFloat visitableFloat) ;
    public void visitCollection(Collection collection);
}
