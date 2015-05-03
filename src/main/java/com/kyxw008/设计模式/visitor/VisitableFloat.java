package com.kyxw008.设计模式.visitor;

/**
 * Created by kyxw007 on 15/3/21.
 */
public class VisitableFloat implements Visitable {
    private float value;

    VisitableFloat(float _value){
        this.value = _value;
    }

    public float getValue(){
        return this.value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }
}
