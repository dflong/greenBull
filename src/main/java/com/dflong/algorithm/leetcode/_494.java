package com.dflong.algorithm.leetcode;

public class _494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // L - R = target
        // L + R = sum;
        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int L = (target + sum) / 2;

        // n个数中目标和为L的组合数
        int[][] dp = new int[nums.length][L + 1];

        // 递推公式     不放当前物品     放当前物品
        // dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]

        // 初始化
        for (int i = 0; i <= L; i ++) {
            if (i == nums[0]) dp[0][i] = 1;
        }

        int zeroNum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) zeroNum++;
            dp[i][0] = (int) Math.pow(2.0, zeroNum);
        }

        // 遍历顺序
        for(int i = 1; i < nums.length; i ++) {
            for (int j = 1; j <= L; j ++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][L];
    }

    // 回溯
    int res = 0;
    public void backTracking(int[] nums, int target, int sum, int idx) {
        if (sum == target) {
            res ++;
        }

        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
            backTracking(nums, target, sum, i + 1);
            sum -= nums[i];
        }
    }
}
