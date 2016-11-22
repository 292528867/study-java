package com.yk.example.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yukui on 2016/10/18.
 */
public class ThreadExample {
	
	public static void main(String[] args){
		System.out.println("How to use wait and notify method in Java"); 
		System.out.println("Solving Producer Consumper Problem"); 
		Queue<Integer> buffer = new LinkedList<Integer>(); 
		int maxSize = 10; 
		Thread producer = new Producer(buffer, maxSize, "PRODUCER"); 
		Thread consumer = new Consumer(buffer, maxSize, "CONSUMER"); 
		producer.start(); 
		consumer.start();
	}
}
