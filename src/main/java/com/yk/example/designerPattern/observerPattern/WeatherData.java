package com.yk.example.designerPattern.observerPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private float temperature;
	private float pressure;
	private float humidity;

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(observer);
		if (index > 0) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
        for(Observer ob : observers){
        	ob.update(this.temperature, this.humidity, this.pressure);
        }
	}
	
	/**
	 * 当从气象站得到更新测量值时，我们通知观察者
	 */
	public void measurementsChange(){
		notifyObservers();
	}
	
	public void setMeasurements(float tem,float humidity,float pressure){
		this.temperature = tem;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChange();
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

}
