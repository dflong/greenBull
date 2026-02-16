package com.dflong.algorithm.leetcode;

import java.util.Stack;

public class _316 {

    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[256]; // 去重
        int[] count = new int[256]; // 计数

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            count[s.charAt(i)] ++;
        }

        for (char c : s.toCharArray()) {
            count[c] --;

            if (visited[c]) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }

                visited[stack.pop()] = false;
            }

            stack.push(c);
            visited[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
