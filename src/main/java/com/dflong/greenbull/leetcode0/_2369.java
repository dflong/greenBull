package com.dflong.greenbull.leetcode0;

public class _2369 {

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        if (nums[0] == nums[1]) {
            dp[1] = true;
        }
        if (n == 2) return dp[1];
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            dp[2] = true;
        }
        if (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]) {
            dp[2] = true;
        }

        for (int i = 3; i < n; i ++) {
            if (nums[i] == nums[i - 1] && dp[i - 2]) {
                dp[i] = true;
            } else if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && dp[i - 3]) {
                dp[i] = true;
            } else if (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && dp[i - 3]) {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }
}
