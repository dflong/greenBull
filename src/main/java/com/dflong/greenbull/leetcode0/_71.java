package com.dflong.greenbull.leetcode0;

import java.util.Stack;

public class _71 {

    public static void main(String[] args) {

        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.isEmpty() || s.contains("/") || s.equals(".")) {

            } else {
                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
        }

        int delNum = 0;
        String res = "";
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            res = pop + res;
            res = "/" + res;
        }

        if (res.isEmpty()) {
            res += "/";
        }

        return res;
    }
}
