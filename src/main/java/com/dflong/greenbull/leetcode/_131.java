package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _131 {

    public static void main(String[] args) {
        new _131().partition("aab");
    }

    public List<List<String>> partition(String s) {
        this.s = s;
        backTracking(0, new StringBuilder());
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    String s;

    public void backTracking(int idx, StringBuilder sb) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValid(sb)) {
                list.add(sb.toString());
                backTracking(i + 1, new StringBuilder());
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isValid(StringBuilder sb) {
        int L = 0, R = sb.length() - 1;
        while (L < R) {
            if (sb.charAt(L) != sb.charAt(R)) {
                return false;
            }
            L ++;
            R --;
        }
        return true;
    }
}
