package com.yk.example.thread;

/**
 * Created by yukui on 2016/10/18.
 */
public class MyRunnable implements Runnable {

	private int count= 5;
	
    @Override
    public void run() {
        for(int i=0 ; i<5 ;i++){
        	if(count>0){
        		System.out.println("票还剩"+count--);
        	}
        }
    }
    
    public static void main(String[] args){
    	MyRunnable mr = new MyRunnable();
    	Thread thread1 = new Thread(mr);
    	//Thread thread2 = new Thread(mr);
    	thread1.start();
        for(int i=0;i<10;i++){
        	if(i>5){
        		try {
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		System.out.println("main 线程执行-->"+i);
        	}
        }
    }
}
