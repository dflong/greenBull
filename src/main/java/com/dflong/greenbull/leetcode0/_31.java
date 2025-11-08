package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _31 {

    public void nextPermutation(int[] nums) {
        int idx = nums.length + 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int minIdx = i + 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i] && nums[j] < nums[minIdx]) {
                        minIdx = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;

                idx = i;
                break;
            }
        }
        if (idx == nums.length + 1) {
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums, idx + 1, nums.length);
    }
}
