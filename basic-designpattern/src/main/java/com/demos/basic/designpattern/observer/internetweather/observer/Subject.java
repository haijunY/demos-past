package com.demos.basic.designpattern.observer.internetweather.observer;

public interface Subject {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
