package com.yhj.study.designpattern.observer.internetweather.model;

import top.yhj1.designpattern.observer.internetweather.observer.Observer;

public class ForcastConditions implements Observer {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(float mTemperatrue, float mPressure, float mHumidity) {
        this.mTemperature = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display(){
        System.out.println("**明天温度:"+(mTemperature+Math.random())+"**");
        System.out.println("**明天气压:"+(mPressure+10*Math.random())+"**");
        System.out.println("**明天湿度:"+(mHumidity+Math.random())+"**");
    }

}
