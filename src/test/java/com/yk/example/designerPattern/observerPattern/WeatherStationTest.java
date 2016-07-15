package com.yk.example.designerPattern.observerPattern;



/**
 * Created by yukui on 2016/7/13.
 */
public class WeatherStationTest  {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay ccdConditionDisplay =
                new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.3f);
    }
}