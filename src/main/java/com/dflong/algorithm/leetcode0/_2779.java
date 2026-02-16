package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _2779 {

    public static void main(String[] args) {
        new _2779().maximumBeauty(new int[]{4,6,1,2}, 2);
    }

    public int maximumBeauty(int[] nums, int k) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        // 1, 2, 4, 6
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] - 2 * k > nums[j]) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;

    }
}
