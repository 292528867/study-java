package com.yk.example.stack;

import java.util.Scanner;

/**
 * Created by yukui on 2016/7/27.
 */
public class Test {

    public static void main(String[] args) throws  Exception{
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
