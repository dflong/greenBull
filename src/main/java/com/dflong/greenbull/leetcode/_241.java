package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _241 {

    public static void main(String[] args) {
        new _241().diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(0, expression.length() - 1, expression);
    }

    public List<Integer> dfs(int L, int R, String s) {
        List<Integer> res = new ArrayList<>();

        for (int i = L; i <= R; i ++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            }

            List<Integer> left = dfs(L, i - 1, s);
            List<Integer> right = dfs(i + 1, R, s);

            for (int a : left) {
                for (int b : right) {
                    if (s.charAt(i) == '+') {
                        res.add(a + b);
                    } else if (s.charAt(i) == '-') {
                        res.add(a - b);
                    } else if (s.charAt(i) == '*') {
                        res.add(a * b);
                    }
                }
            }
        }

        if (res.isEmpty()) {
            int cur = 0;
            for (int i = L; i <= R; i ++) {
                cur = cur * 10 + (s.charAt(i) - '0');
            }

            res.add(cur);
        }

        return res;
    }
}
