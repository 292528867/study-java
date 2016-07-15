package com.yk.example.designerPattern.observerPattern.bulidin;

/**
 * Created by yukui on 2016/7/13.
 */
public class WeatherStationTest {

    public static void main(String[] args) {
        WeatherDataBuildin weatherDataBuildin = new WeatherDataBuildin();
        CurrentConditionDisplayBuildin cdb = new CurrentConditionDisplayBuildin(weatherDataBuildin);
        cdb.update(weatherDataBuildin,null);
    }
}
