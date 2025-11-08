package com.dflong.greenbull.leetcode0;

import java.util.Stack;

public class _224 {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        // 1-(0-2+(0-4))
    }

    public static int calculate(String s) {
        Stack<Integer> signStack = new Stack<>();
        int sign = 1;
        signStack.push(sign);
        int res = 0;

        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i ++;
            } else if (c == '+') {
                sign = signStack.peek();
                i ++;
            } else if (c == '-') {
                sign = -signStack.peek();
                i ++;
            } else if (c == '(') {
                signStack.push(sign);
                i ++;
            } else if (c == ')') {
                signStack.pop();
                i ++;
            } else {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                res += sign * num;
            }
        }
        return res;
    }



}
