package com.demos.basic.designpattern.strategy.stimulateduck.duck;


import com.demos.basic.designpattern.strategy.stimulateduck.flybehaviour.GoodFlyBehaviour;
import com.demos.basic.designpattern.strategy.stimulateduck.quackbehaviour.GeGeQuackBehaviour;

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
