package com.dflong.algorithm.leetcode;

public class _231 {

    public boolean isPowerOfTwo(int n) {
        int big = 1 << 30;

        return n > 0 &&  big % n == 0;
    }
}
