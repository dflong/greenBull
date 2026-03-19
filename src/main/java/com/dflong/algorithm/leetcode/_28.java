package com.dflong.algorithm.leetcode;

public class _28 {

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        for (int i = 0, j = 0; i < haystack.length(); i ++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j ++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    // kmp算法
    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        for (int i = 1, j = 0; i < pattern.length(); i ++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j ++;
            }
            next[i] = j;
        }

        return next;
    }
}
