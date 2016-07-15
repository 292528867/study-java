package com.yk.example.designerPattern.singletonPattern;

/**
 * Created by yukui on 2016/7/15.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Singleton1.getInstance().hashCode());
    }

    public static void main(String[] args) {
        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
             threads[i] = new MyThread();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
