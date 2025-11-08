package com.dflong.greenbull.leetcode0;

public class _416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < target + 1; i++) {
            if (nums[0] == i) {
                dp[0][i] = nums[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j ++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[n - 1][target] == target;
    }

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < n; i ++) {
            for (int j = target; j >= nums[i]; j --) { // 与二维数组相反
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
