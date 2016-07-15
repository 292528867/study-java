package com.yk.example.designerPattern.observerPattern;

public class WeatherStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay ccdConditionDisplay = 
        		new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.3f);
	}

}
