package com.dflong.algorithm.leetcode0;

public class _2321 {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(max(nums1, nums2), max(nums2, nums1));
    }

    public int max(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length];
        dp[0] = nums1[0] - nums2[0];
        int max = dp[0];

        int sum = nums2[0];
        for (int i = 1; i < nums1.length; i ++) {
            dp[i] = Math.max(dp[i - 1] + nums1[i] - nums2[i], nums1[i] - nums2[i]);
            max = Math.max(max, dp[i]);

            sum += nums2[i];
        }
        return sum + max;
    }

}
