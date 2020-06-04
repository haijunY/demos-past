package com.yhj.study.designpattern.strategy.stimulateduck.duck;

import top.yhj1.designpattern.strategy.stimulateduck.flybehaviour.GoodFlyBehaviour;
import top.yhj1.designpattern.strategy.stimulateduck.quackbehaviour.GeGeQuackBehaviour;

public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        this.flyBehaviour = new GoodFlyBehaviour();
        this.quackBehaviour = new GeGeQuackBehaviour();
    }

    @Override
    public void display() {
        System.out.println("**RedHead**");
    }

}
