package com.yk.example.designerPattern.strategyPattern.duck;


import com.yk.example.designerPattern.strategyPattern.fly.FlyNoWay;
import com.yk.example.designerPattern.strategyPattern.quack.Quack;

public class MallardDuck extends Duck {
	
	 public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("����һ����ͷѼ��");
	}


/*	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("��Ѽ�Ӳ����");
	}*/

    
	
}
