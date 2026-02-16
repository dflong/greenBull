package com.dflong.algorithm.leetcode0;

public class _33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, n = r;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            // 这部分是有序的
            if (nums[0] <= nums[m]) {
                if (nums[0] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // 这部分有谷底
                if (target > nums[m] && nums[n] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
