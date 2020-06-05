package com.demos.basic.designpattern.strategy.stimulateduck.duck;


import com.demos.basic.designpattern.strategy.stimulateduck.flybehaviour.FlyBehaviour;
import com.demos.basic.designpattern.strategy.stimulateduck.quackbehaviour.QuackBehaviour;

public abstract class Duck {

    FlyBehaviour flyBehaviour;

    QuackBehaviour quackBehaviour;

    public Duck(){

    }
    public void fly(){
        this.flyBehaviour.fly();
    }

    public void quack(){
        this.quackBehaviour.quack();
    }

    public abstract void display();

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
