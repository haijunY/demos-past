package com.demos.basic.designpattern.strategy.stimulateduck.quackbehaviour;

public class NoQuackBehaviour implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("---NoQuack---");
    }

}
