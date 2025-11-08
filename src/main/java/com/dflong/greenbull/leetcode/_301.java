package com.dflong.greenbull.leetcode;

import java.util.HashSet;
import java.util.*;

public class _301 {

    public static void main(String[] args) {
        new _301().removeInvalidParentheses("()())()");
    }

    String s;
    int n;
    Set<String> set;
    int maxLength = 0; // 删除最少得到的字符串
    int maxScore; // 单括号最大数量

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        this.s = s;
        n = s.length();

        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                l ++;
            } else if (s.charAt(i) == ')') {
                r ++;
            }
        }

        maxScore = Math.min(l, r);
        dfs(0, "", 0);

        return new ArrayList<>(set);
    }

    private void dfs(int idx, String path, int score) {
         if (score > maxScore || score < 0) {
             return;
         }

         if (idx == n) {
             if (score == 0 && path.length() >= maxLength) {
                 if (path.length() > maxLength) {
                     maxLength = path.length();
                     set.clear();
                 }
                 set.add(path);
             }
             return;
         }

         char c = s.charAt(idx);

        if (c == '(') {
            dfs(idx + 1, path + c, score + 1);
            dfs(idx + 1, path, score);
        } else if (c == ')') {
            dfs(idx + 1, path + c, score - 1);
            dfs(idx + 1, path, score);
        } else {
            dfs(idx + 1, path + c, score);
        }
    }
}
