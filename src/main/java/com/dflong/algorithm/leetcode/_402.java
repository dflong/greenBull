package com.dflong.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _402 {

    public static void main(String[] args) {
        new _402().removeKdigits("1432219", 3);
    }

    public String removeKdigits(String num, int k) {
        // 单调栈
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i ++) {
            char c = num.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k --;
            }

            stack.addLast(c);
        }

        // 还有剩余k
        for (int i = 0; i < k; i ++) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        while (!stack.isEmpty()) {
            Character c = stack.pollFirst();
            if (flag && c == '0') {
                continue; // 前导0不加入
            }
            flag = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    // 回溯超时
    public void dfs(String num, int idx, StringBuilder sb, int count) {
        if (count == n) {
            if (sb.length() == 0) {
                res = "0";
                return;
            }
            if (sb.length() < res.length() || sb.toString().compareTo(res) < 0) {
                res = sb.toString();
            }
            return;
        }

        for (int i = idx; i < num.length(); i ++) {
            if (sb.length() == 0 && num.charAt(i) == '0') {

            } else {
                sb.append(num.charAt(i));
            }
            dfs(num, i + 1, sb, count + 1);
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    String res;
    int n;
}
