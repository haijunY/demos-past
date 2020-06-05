package com.demos.basic.designpattern.battercake.v2;

public class BattercakeDecortor extends Battercake {

    private Battercake battercake;

    public BattercakeDecortor(Battercake battercake){
        this.battercake = battercake;
    }

    @Override
    String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    int price() {
        return this.battercake.price();
    }
}
