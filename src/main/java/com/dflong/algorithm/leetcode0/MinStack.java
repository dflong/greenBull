package com.dflong.algorithm.leetcode0;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        minStack.top();      //--> 返回 0.
        minStack.getMin();   //--> 返回 -2.

    }

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(long val) {
       if (stack.isEmpty()) {
           stack.push(0L);
           min = val;
       } else {
           long diff = val - min;
           stack.push(diff);
           if (diff < 0) {
               min = val;
           }
       }
    }

    public void pop() {
        Long diff = stack.pop();
        if (diff < 0) {
            min = min - diff;
        }
    }

    public long top() {
        Long diff = stack.peek();
        if (diff < 0) {
            return min;
        } else {
            return min + diff;
        }
    }

    public long getMin() {
        return min;
    }
}
