package com.yhj.study.designpattern.observer.internetweather;


import com.yhj.study.designpattern.observer.internetweather.model.CurrentConditions;
import com.yhj.study.designpattern.observer.internetweather.model.ForcastConditions;
import com.yhj.study.designpattern.observer.internetweather.model.WeatherData;

/**
 * 观察者模式就像订牛奶
 */
public class InternetWeather {

	public static void main(String[] args) {
		
		CurrentConditions mCurrentConditions;
		ForcastConditions mForcastConditions;
		WeatherData mWeatherDataSt;
		
		mWeatherDataSt=new WeatherData();
		mCurrentConditions=new CurrentConditions();
		mForcastConditions=new ForcastConditions();
		
		mWeatherDataSt.registerObserver(mCurrentConditions);
		mWeatherDataSt.registerObserver(mForcastConditions);
		
		mWeatherDataSt.setData(30, 150, 40);
		mWeatherDataSt.removeObserver(mCurrentConditions);
		mWeatherDataSt.setData(40, 250, 50);
	}

}
