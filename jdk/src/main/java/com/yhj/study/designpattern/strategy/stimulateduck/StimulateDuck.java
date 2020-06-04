package com.yhj.study.designpattern.strategy.stimulateduck;

import top.yhj1.designpattern.strategy.stimulateduck.duck.Duck;
import top.yhj1.designpattern.strategy.stimulateduck.duck.GreenHeadDuck;
import top.yhj1.designpattern.strategy.stimulateduck.duck.RedHeadDuck;

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
