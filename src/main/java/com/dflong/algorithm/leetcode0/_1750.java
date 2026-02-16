package com.dflong.algorithm.leetcode0;

public class _1750 {

    public int minimumLength(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return r - l + 1;
            }
            while (s.charAt(l) == s.charAt(l + 1) && l + 1 < r) {
                l ++;
            }
            while (s.charAt(r) == s.charAt(r - 1) && r - 1 > l) {
                r --;
            }
            l ++;
            r --;
        }
        return r - l + 1;
    }
}
