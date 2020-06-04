package com.yhj.study.designpattern.battercake.v2;

public class Battercake extends AbstractBattercake {
    @Override
    String getMsg() {
        return "煎饼";
    }

    @Override
    int price() {
        return 5;
    }
}
