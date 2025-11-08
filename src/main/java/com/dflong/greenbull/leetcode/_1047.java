package com.dflong.greenbull.leetcode;

import java.util.Stack;

public class _1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i ++) {
            if (!stack.isEmpty() && stack.peek() == charArray[i]) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
