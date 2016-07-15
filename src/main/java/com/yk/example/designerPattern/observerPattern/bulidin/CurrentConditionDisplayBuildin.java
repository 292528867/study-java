package com.yk.example.designerPattern.observerPattern.bulidin;

import com.yk.example.designerPattern.observerPattern.DisplayElement;
import com.yk.example.designerPattern.observerPattern.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yukui on 2016/7/13.
 */
public class CurrentConditionDisplayBuildin implements Observer ,DisplayElement {

    private float tempersure;
    private float humidity;
    private Observable observable;

    public CurrentConditionDisplayBuildin(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions :"+this.tempersure
                +" F degrees and "+this.humidity+"% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataBuildin) {
            WeatherDataBuildin weatherDataBuildin = (WeatherDataBuildin) o;
            this.tempersure = weatherDataBuildin.getTemperature();
            this.humidity = weatherDataBuildin.getHumidity();
            display();
        }
    }
}
