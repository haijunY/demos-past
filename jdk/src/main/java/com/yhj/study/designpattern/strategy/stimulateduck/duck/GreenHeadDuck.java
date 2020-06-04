package com.yhj.study.designpattern.strategy.stimulateduck.duck;

import top.yhj1.designpattern.strategy.stimulateduck.flybehaviour.BadFlyBehaviour;
import top.yhj1.designpattern.strategy.stimulateduck.quackbehaviour.GaGaQuackBehaviour;

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
