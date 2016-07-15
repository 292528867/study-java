package com.yk.example.designerPattern.observerPattern;

public class CurrentConditionDisplay implements Observer,DisplayElement {
    
	private float tempersure;
	private float humidity;
	private Subject weatherData;
		
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions :"+this.tempersure
				+" F degrees and "+this.humidity+"% humidity");
	}

	@Override
	public void update(float temp, float humdity, float pressure) {
		// TODO Auto-generated method stub
		this.tempersure = temp;
		this.humidity = humdity;
		display();
	}
   
}
