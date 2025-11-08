package com.dflong.greenbull.leetcode;

public class _343 {

    public int integerBreak(int n) {
        // 第n个数获得最大乘积
        int[] dp = new int[n + 1];

        // 递推公式 dp[n] = Math.max(dp[i], dp[i - j] * j, (i - j) * j)

        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // 遍历顺序
        for (int i = 3; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                int temp = Math.max((i - j) * j, dp[i - j] * j);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }
}
