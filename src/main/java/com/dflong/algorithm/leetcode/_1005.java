package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (i < j && k > 0) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
            i ++;
            k --;
        }

        k = k % 2;
        Arrays.sort(nums);
        nums[0] = -nums[0];

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
