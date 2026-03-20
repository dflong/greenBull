package com.dflong.algorithm.leetcode0;

public class _2980 {

    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                cnt ++;
            }
            if (cnt > 1) {
                return true;
            }
        }
        return false;
    }
}
