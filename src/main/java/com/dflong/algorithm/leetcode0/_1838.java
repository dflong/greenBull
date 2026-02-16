package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        long sum = 0;
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            sum = sum + (long) (nums[r] - nums[r - 1]) * (r - l);
            while (sum > k) {
                sum = sum - (nums[r] - nums[l]);
                l ++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
