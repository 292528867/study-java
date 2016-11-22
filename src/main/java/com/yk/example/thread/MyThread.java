package com.yk.example.thread;

/**
 * Created by yukui on 2016/10/18.
 */
public class MyThread extends Thread {

    private String name;
    
    private int count = 5;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name+"运行:"+ count--);
        }
    }
    
    public static void main(String[] arg0){
    	MyThread thread1 = new MyThread("a");
    	MyThread thread2 = new MyThread("b");
    	thread1.start();
    	thread2.start();
    }
}
