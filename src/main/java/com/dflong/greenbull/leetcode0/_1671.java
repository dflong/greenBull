package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _1671 {

    public int minimumMountainRemovals(int[] nums) {
        // 最长递增、递减子序列
        int n = nums.length;
        int[] dp = getLcs(nums);

        int[] nums1 = reverse(nums);
        int[] dp1 = getLcs(nums1);
        dp1 = reverse(dp1);

        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (dp[i] > 1 && dp1[i] > 1) {
                max = Math.max(max, dp[i] + dp1[i] - 1);
            }
        }
        return n - max;
    }

    public int[] getLcs(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public int[] reverse(int[] nums) {
        int n = nums.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        return reversed;
    }

}
