package com.yk.example.thread;

import org.junit.Test;

/**
 * Created by yukui on 2016/10/18.
 */
public class ThreadExampleTest {

    @Test
    public void  testThread() {
        MyThread thread1 = new MyThread("a");
        MyThread thread2 = new MyThread("b");
        thread1.start();
        thread2.start();
    }

    @Test
    public void testRunnable(){
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();
        System.out.println(thread1.getName());
        System.out.println(Thread.currentThread().getName());

    }
    
  

}