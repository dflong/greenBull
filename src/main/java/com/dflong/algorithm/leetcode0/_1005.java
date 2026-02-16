package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k --;
            } else {
                break;
            }
        }

        if (k % 2 == 1) {
            if (nums[0] < nums[1]) {
                nums[0] = -nums[0];
            } else {
                nums[1] = -nums[1];
            }
//            Arrays.sort(nums);
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
