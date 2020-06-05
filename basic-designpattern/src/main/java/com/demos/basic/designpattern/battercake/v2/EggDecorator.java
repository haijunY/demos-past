package com.demos.basic.designpattern.battercake.v2;

public class EggDecorator extends BattercakeDecortor {


    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    int price() {
        return super.price() + 1;
    }
}
