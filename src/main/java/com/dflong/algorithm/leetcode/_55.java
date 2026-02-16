package com.dflong.algorithm.leetcode;

public class _55 {

    public  boolean canJump(int[] nums) {
        int res = 0;

        for (int i = 0; i <= res; i++) {
            res = Math.max(res, nums[i] + i);
            if (res >= nums.length - 1) return true;
        }

        return false;
    }
}
