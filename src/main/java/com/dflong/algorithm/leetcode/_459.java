package com.dflong.algorithm.leetcode;

public class _459 {

    public boolean repeatedSubstringPattern(String s) {
        String s1 = s + s;
        for (int i = 1; i < s1.length() - s.length(); i ++) {
            if (s.equals(s1.substring(i, i + s.length())))
                return true;
        }
        return false;
    }
}
