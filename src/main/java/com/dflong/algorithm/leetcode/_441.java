package com.dflong.algorithm.leetcode;

public class _441 {

    public int arrangeCoins(int n) {
        int i = 1;
        while (n > 0) {
            if (n >= i) {
                n -= i;
                i ++;
            } else {
                return i - 1;
            }
        }

        return i - 1;
    }
}
