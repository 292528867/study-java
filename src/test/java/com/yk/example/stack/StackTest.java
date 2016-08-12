package com.yk.example.stack;

import org.junit.*;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by yukui on 2016/8/12.
 */
public class StackTest {

    @org.junit.Test
    public void test() throws Exception {
        SequenceStack ss = new SequenceStack();
        Scanner in = new Scanner(System.in);
        int temp;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数");
            temp = in.nextInt();
            ss.push(temp);
        }
        while (!ss.isEmpty()) {
            System.out.println(ss.pop());
        }
    }

}