package com.yk.example.thread;

public class ThreadA {

	public static void main(String[] args){
		ThreadB b= new ThreadB();
		b.start();
	/*	synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Total is: " + b.total);
		}*/
		System.out.println("Total is: " + b.total);

	}
	
	public static class ThreadB extends Thread{
		private int total;
		
		@Override
	    public void run(){
	    	/*synchronized (this) {
				for(int i=0;i<100;i++){
					total += i;
				}
				notify();
			}*/
			for(int i=0;i<100;i++){
				total += i;
			}
	    }
	}
}

