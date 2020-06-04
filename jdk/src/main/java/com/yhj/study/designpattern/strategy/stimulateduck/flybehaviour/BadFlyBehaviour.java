package com.yhj.study.designpattern.strategy.stimulateduck.flybehaviour;

public class BadFlyBehaviour implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("--BadFly--");
    }

}
