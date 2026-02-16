package com.dflong.algorithm.leetcode;

public class _977 {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            if (Math.abs(nums[L]) > Math.abs(nums[R])) {
                res[idx --] = nums[L] * nums[L];
                L++;
            } else {
                res[idx --] = nums[R] * nums[R];
                R--;
            }
        }
        return res;
    }
}
