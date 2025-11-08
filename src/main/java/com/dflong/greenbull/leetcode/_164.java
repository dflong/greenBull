package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _164 {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);

        int max = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
