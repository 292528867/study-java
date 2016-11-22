package com.yk.example.algorithm;

import com.yk.example.algorithm.FibonacciExample;
import org.junit.Test;

/**
 * Created by yukui on 2016/9/7.
 */
public class FibonacciExampleTest {

    @Test
    public void fibonacciTest() throws Exception {
        int n = 50;
        long start1 = System.currentTimeMillis();
        long result1 = FibonacciExample.fibonacci1(n);
        long end1 = System.currentTimeMillis();
        System.out.println("2层递归所需时间:"+ (end1-start1)+"最终结果是："+result1);

        long start3 = System.currentTimeMillis();
        long result3 = FibonacciExample.fibonacci3(n);
        long end3 = System.currentTimeMillis();
        System.out.println("递推所需时间:"+ (end3-start3)+"最终结果是："+result3);

        long start4 = System.currentTimeMillis();
        long result4 = FibonacciExample.fibonacci4(n);
        long end4 = System.currentTimeMillis();
        System.out.println("矩阵所需时间:"+ (end4-start4)+"最终结果是："+result4);

    }
}