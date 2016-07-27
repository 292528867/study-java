package com.yk.example.stack;

/**
 * Created by yukui on 2016/7/27.
 */
public class SequenceStack implements Stack {

    Object[] stack; //对象数组
    final int defaultSize = 10;//栈默认大小
    int top; //栈顶位置的下标，可以理解为栈的实际长度
    int maxSize; //最大长度

    /**
     * 默认长度
     */
    public SequenceStack() {
        init(defaultSize);
    }

    /**
     * 指定长度
     *
     * @param size
     */
    public SequenceStack(int size) {
        init(size);
    }

    private void init(int size) {
        this.maxSize = size;
        top = 0;
        stack = new Object[size];
    }

    @Override
    public void push(Object o) throws Exception {
        if (top == maxSize) {
            throw new Exception("堆栈已满");
        }
        stack[top] = o;
        top++;
    }

    @Override
    public Object pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空");
        }
        top--;
        return stack[top];
    }

    @Override
    public Object getTop() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
}
