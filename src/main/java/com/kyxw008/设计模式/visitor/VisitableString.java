package com.kyxw008.设计模式.visitor;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class VisitableString implements Visitable{
    private String value;

    VisitableString(String _value){
        this.value = _value;
    }
    public String getValue(){
        return this.value;
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visitString(this);
    }
}
