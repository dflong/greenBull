package com.dflong.greenbull.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> q = null;
    Queue<Integer> q1 = null;

    public MyStack() {
        q = new LinkedList<>();
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        while (!q.isEmpty()) {
            q1.add(q.poll());
        }
        Queue<Integer> temp = q;
        q = q1;
        q1 = temp;
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
