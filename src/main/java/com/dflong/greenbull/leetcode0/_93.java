package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _93 {

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        this.s = s;
        dfs(s, 0);
        return res;
    }

    List<String> res = new ArrayList<>();
    int pointNum = 0;
    String s;

    public void dfs(String s, int index) {
        if (pointNum == 3) {
            if (isValid(s, index, s.length() - 1)) {
                res.add(s);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum ++;
                dfs(s, i + 2);
                pointNum --;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }

    public boolean isValid(String s, int i, int j) {
        if (i > j) return false;
        if (i != j && s.charAt(i) == '0') return false;
        int num = 0;
        for (;i <= j; i ++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) return false;
        }
        return true;
    }
}
