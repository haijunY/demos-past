package com.demos.basic.designpattern.strategy.stimulateduck.duck;


import com.demos.basic.designpattern.strategy.stimulateduck.flybehaviour.BadFlyBehaviour;
import com.demos.basic.designpattern.strategy.stimulateduck.quackbehaviour.GaGaQuackBehaviour;

public class GreenHeadDuck extends Duck {

    public GreenHeadDuck(){
        this.flyBehaviour = new BadFlyBehaviour();
        this.quackBehaviour = new GaGaQuackBehaviour();
    }

    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }

}
