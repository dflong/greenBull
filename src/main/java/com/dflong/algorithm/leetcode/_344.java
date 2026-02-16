package com.dflong.algorithm.leetcode;

public class _344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i ++ < j --) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
