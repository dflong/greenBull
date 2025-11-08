package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _394 {

    public static void main(String[] args) {
        _394 v = new _394();
        String s = v.decodeString("3[a]2[bc]");
        System.out.println();
    }

    int i = 0;
    Stack<String> stack = new Stack<>();
    public String decodeString(String s) {

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || c == '[') {
                stack.push(c + "");
                i ++;
            } else if (Character.isDigit(c)) {
                getDigital(s);
            }
            // ]
            else {
                // 弹出的字母
                List<String> str = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    str.add(stack.pop());
                }
                // 弹出 [
                stack.pop();
                // 弹出数字
                String numStr = stack.pop();
                // 生成字符串
                String s1 = buildString(Integer.parseInt(numStr), str);
                // 进栈
                stack.push(s1);
                i ++;
            }
        }

        // 生成结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public void getDigital(String s) {
        StringBuffer digital = new StringBuffer();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digital.append(c);
                i ++;
            } else {
                stack.push(digital.toString());
                return;
            }
        }
    }

    public String buildString(int n, List<String> str) {
        StringBuffer sb1 = new StringBuffer();

        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < str.size(); j++) {
            sb1.append(str.get(j));
        }
        for (int i = 0; i < n; i++) {
            sb.append(sb1);
        }
        return sb.toString();
    }
}
