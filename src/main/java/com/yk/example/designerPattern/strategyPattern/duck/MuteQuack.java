package com.yk.example.designerPattern.strategyPattern.duck;


import com.yk.example.designerPattern.strategyPattern.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("ʲô���������������");
	}
   
}
