package com.dflong.algorithm.leetcode0;

import java.util.Stack;

public class _232 {


}

class MyQueue {

    Stack<Integer> pushStack = null;
    Stack<Integer> getStack = null;

    public MyQueue() {
        pushStack = new Stack<>();
        getStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (!getStack.isEmpty()) {
            return getStack.pop();
        } else {
            while (!pushStack.isEmpty()) {
                getStack.push(pushStack.pop());
            }
            return getStack.pop();
        }
    }

    public int peek() {
        if (!getStack.isEmpty()) {
            return getStack.peek();
        } else {
            while (!pushStack.isEmpty()) {
                getStack.push(pushStack.pop());
            }
            return getStack.peek();
        }
    }

    public boolean empty() {
        if (!getStack.isEmpty()) {
            return false;
        } else {
            while (!pushStack.isEmpty()) {
                getStack.push(pushStack.pop());
            }
            return getStack.isEmpty();
        }
    }
}
