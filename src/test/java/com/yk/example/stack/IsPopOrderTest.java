package com.yk.example.stack;

import static com.yk.example.stack.IsPopOrder.isPopOrder;

/**
 * Created by yukui on 2016/8/12.
 */
public class IsPopOrderTest {

    @org.junit.Test
    public void test() {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};
        System.out.println("true: " + isPopOrder(push, pop1));
//        System.out.println("true: " + isPopOrder(push, pop2));
//        System.out.println("false: " + isPopOrder(push, pop3));
//        System.out.println("false: " + isPopOrder(push, pop4));
        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));
        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));
    }

}