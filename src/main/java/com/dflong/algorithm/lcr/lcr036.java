package com.dflong.algorithm.lcr;

import java.util.LinkedList;

public class lcr036 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.addLast(stack.pollLast() + stack.pollLast());
                    break;
                case "-":
                    int a = stack.pollLast();
                    stack.addLast(stack.pollLast() - a);
                    break;
                case "*":
                    stack.addLast(stack.pollLast() * stack.pollLast());
                    break;
                case "/":
                    int divide = stack.pollLast();
                    stack.addLast(stack.pollLast() / divide);
                    break;
                default:
                    stack.addLast(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pollLast();
    }
}
