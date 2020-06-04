package com.yhj.study.designpattern.battercake.v2;

public class SausageDecortor extends BattercakeDecortor {

    public SausageDecortor(Battercake battercake) {
        super(battercake);
    }

    @Override
    String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    int price() {
        return super.price() + 2;
    }
}
