package com.demos.basic.designpattern.observer.internetweather.model;


import com.demos.basic.designpattern.observer.internetweather.observer.Observer;
import com.demos.basic.designpattern.observer.internetweather.observer.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    private ArrayList<Observer> mObservers;

    public WeatherData(){
        mObservers = new ArrayList<>();
    }

    public void setData(float mTemperatrue,float mPressure,float mHumidity){
        this.mTemperature = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        mObservers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(mObservers.contains(o)){
            mObservers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : mObservers){
            o.update(mTemperature, mPressure, mHumidity);
        }
    }

}
