package com.dflong.greenbull.leetcode;

public class _28 {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == n - 1) return i - j;
                i ++;
                j ++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
