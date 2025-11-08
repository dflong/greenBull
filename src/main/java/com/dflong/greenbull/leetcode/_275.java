package com.dflong.greenbull.leetcode;

public class _275 {

    public int hIndex(int[] citations) {
        int n = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= n) return n;
            n --;
        }

        return 0;
    }
}
