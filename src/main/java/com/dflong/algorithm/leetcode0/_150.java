package com.dflong.algorithm.leetcode0;

import java.util.Stack;

public class _150 {

    public static void main(String[] args) {
        String[] a = {"4","13","5","/","+"};
        System.out.println(evalRPN(a));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop()) + "");
            }
            else if (token.equals("-")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(num2 - num1 + "");
            }
            else if (token.equals("*")) {
                stack.push(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()) + "");
            }
            else if (token.equals("/")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(num2 / num1 + "");
            }
            else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
