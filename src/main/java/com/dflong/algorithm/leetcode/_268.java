package com.dflong.algorithm.leetcode;

public class _268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int res = 0;
        for (int i = 0; i <= n; i ++) {
            res = res ^ i; // 对所有数异或
        }

        for (int i : nums) {
            res = res ^ i; // 对所有数异或
        }

        // 所有数都异或了两次，缺失的数只异或了一次
        return res;
    }
}
