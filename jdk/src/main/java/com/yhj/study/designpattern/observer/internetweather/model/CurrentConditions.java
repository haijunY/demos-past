package com.yhj.study.designpattern.observer.internetweather.model;


import com.yhj.study.designpattern.observer.internetweather.observer.Observer;

public class CurrentConditions implements Observer {

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
        System.out.println("***Today mTemperatrue:" + mTemperature + "***");
        System.out.println("***Today mPressure:" + mPressure + "***");
        System.out.println("***Today mHumidity:" + mHumidity + "***");
    }

}
