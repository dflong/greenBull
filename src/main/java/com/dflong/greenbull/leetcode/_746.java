package com.dflong.greenbull.leetcode;

public class _746 {

    public int minCostClimbingStairs(int[] cost) {
        // dp数组含义 dp[n]第n阶台阶的花费
        int[] dp = new int[cost.length + 1];

        // 递推公式 dp[n] = Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2])

        // 初始化

        // 遍历顺序
        for (int n = 2; n <= cost.length; n ++) {
            dp[n] = Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
        }

        // 举例

        return dp[cost.length];
    }
}
