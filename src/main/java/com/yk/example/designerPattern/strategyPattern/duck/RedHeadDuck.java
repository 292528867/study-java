package com.yk.example.designerPattern.strategyPattern.duck;


import com.yk.example.designerPattern.strategyPattern.fly.FlyWithWing;

public class RedHeadDuck extends Duck {
	
	public RedHeadDuck(){
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyWithWing();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("����һ����ͷѼ��");
	}



/*	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("��Ѽ�ӻ��");
	}
*/

	   
}
