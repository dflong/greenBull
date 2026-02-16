package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int average = nums[nums.length / 2];

        int min = 0;
        for (int num : nums) {
            min += Math.abs(num - average);
        }
        return min;
    }
}
