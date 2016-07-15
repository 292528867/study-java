package com.yk.example.designerPattern.strategyPattern.fly;


public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("什么都不会做，不会飞");
	}

}
