package com.yhj.study.designpattern.battercake.v1;

public class BattercakeWithEgg extends Battercake {

    @Override
    public String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    public int price() {
        return super.price() + 1;
    }
}
