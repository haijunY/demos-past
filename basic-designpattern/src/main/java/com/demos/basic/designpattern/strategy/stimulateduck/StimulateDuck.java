package com.demos.basic.designpattern.strategy.stimulateduck;

import com.demos.basic.designpattern.strategy.stimulateduck.duck.Duck;
import com.demos.basic.designpattern.strategy.stimulateduck.duck.GreenHeadDuck;
import com.demos.basic.designpattern.strategy.stimulateduck.duck.RedHeadDuck;

public class StimulateDuck {

    public static void main(String[] args){
        Duck greenHeadDuck = new GreenHeadDuck();
        Duck redHeadDuck = new RedHeadDuck();
        greenHeadDuck.display();
        greenHeadDuck.fly();
        greenHeadDuck.quack();
        redHeadDuck.display();
        redHeadDuck.fly();
        redHeadDuck.quack();
    }

}
