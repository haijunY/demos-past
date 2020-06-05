package com.demos.basic.designpattern.strategy.stimulateduck.flybehaviour;

public class GoodFlyBehaviour implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("---GoodFly---");
    }

}
