package com.yk.example.designerPattern.strategyPattern.duck;


import com.yk.example.designerPattern.strategyPattern.fly.FlyBehavior;
import com.yk.example.designerPattern.strategyPattern.quack.QuackBehavior;

public abstract class Duck {
    
	/* public void quack(){
		 System.out.println("���ɽ�");
	 }*/
	
	 public void swim(){
		 System.out.println("ˮ����Ӿ");
	 }
	 
     public abstract void display();
     
   /*  public void fly(){
    	 
     }*/
     
     FlyBehavior flyBehavior;
     
     QuackBehavior quackBehavior;
     
     public void perfromFly(){
    	 flyBehavior.fly();
     }
     
     public void performQuack(){
    	 quackBehavior.quack();
     }

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
     
     
     
}
