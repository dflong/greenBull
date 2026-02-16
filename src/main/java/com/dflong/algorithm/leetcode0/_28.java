package com.dflong.algorithm.leetcode0;

public class _28 {

    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == n - 1) return i - n + 1;
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
