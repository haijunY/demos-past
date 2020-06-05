package com.demos.basic.designpattern.battercake.v1;

public class BattercakeWithEggAndSausage extends BattercakeWithEgg {

    @Override
    public String getMsg() {
        return super.getMsg() + "1根香肠";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
