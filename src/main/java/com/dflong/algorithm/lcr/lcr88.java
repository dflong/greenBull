package com.dflong.algorithm.lcr;

public class lcr88 {

    public int minCostClimbingStairs(int[] cost) {
        // dp[i] i台阶的最小花费 从前一个位置或前俩个位置跳过来
        int[] dp = new int[cost.length];
        // dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        // 初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 遍历顺序
        for (int i = 2; i < cost.length; i ++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}
