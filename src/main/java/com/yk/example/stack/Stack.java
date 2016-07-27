package com.yk.example.stack;

/**
 * Created by yukui on 2016/7/27.
 */
public interface Stack {

    //入栈
    void push(Object o) throws Exception;

    //出栈
    Object pop() throws Exception;

    //取栈顶元素
    Object getTop() throws Exception;

    //判断栈是否为空
    boolean isEmpty();
    
}
