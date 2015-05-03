package com.kyxw008.设计模式.visitor;

/**
 * Created by kyxw007 on 15/3/21.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
