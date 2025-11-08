package com.dflong.greenbull.leetcode;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> pushStack = null;
    Stack<Integer> getStack = null;
    public MyQueue() {
        pushStack = new Stack<Integer>();
        getStack = new Stack<Integer>();
    }

    public void push(int i) {
        pushStack.push(i);
    }

    public int peek() {
        if (!getStack.isEmpty()) {
            return getStack.peek();
        }
        clear();
        return getStack.peek();
    }

    public int pop() {
        if (!getStack.isEmpty()) {
            return getStack.pop();
        }
        clear();
        return getStack.pop();
    }

    public void clear() {
        while (!pushStack.isEmpty()) {
            getStack.push(pushStack.pop());
        }
    }

    public boolean empty() {
        if (!getStack.isEmpty()) {
            return false;
        }
        clear();
        return getStack.isEmpty();
    }
}
