package com.demos.basic.designpattern.strategy.stimulateduck.flybehaviour;

public class NoFlyBehaviour implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("---NoFly---");
    }

}
