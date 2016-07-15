package com.yk.example.designerPattern.observerPattern.bulidin;

import java.util.Observable;
import java.util.Observer;

/**
 * java api 内置的观察者模式
 * @author yukui
 *
 */
public class WeatherDataBuildin extends Observable {
	
	private float temperature;
	private float pressure;
	private float humidity;

	public WeatherDataBuildin() {
	}

	/**
	 *没有用notifyObservers()传递数据对象，表明是采取是“拉”
	 */
	public void measurementsChange(){
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float tem,float humidity,float pressure){
		this.temperature = tem;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChange();
	}
	
	public float getTemperature() {
		return temperature;
	}
	public float getPressure() {
		return pressure;
	}
	public float getHumidity() {
		return humidity;
	}

   
     
	
}
