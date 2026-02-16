package com.dflong.algorithm.leetcode;

public class _274 {

    public static void main(String[] args) {
        new _274().hIndex(new int[] {3,0,6,1,5});
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        for (int i = 0; i < citations.length; i ++) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j ++) {
                if (citations[j] >= n) {
                    cnt ++;
                }

                if (cnt >= n) {
                    return n;
                }
            }
            n --;
        }

        return n;
    }
}
