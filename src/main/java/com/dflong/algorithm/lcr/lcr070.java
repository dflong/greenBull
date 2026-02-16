package com.dflong.algorithm.lcr;

public class lcr070 {

    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            res ^= nums[i];
        }
        return res;
    }
}
