package com.dflong.greenbull.leetcode;

public class _375 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // 左下到右上
        for (int i = n; i >= 1; i --) { // 左边界
            for (int j = i + 1; j <= n; j ++) { // 右边界
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k ++) { // k==j时 j + cost[i][j - 1]大于k<j
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }

        return dp[1][n];
    }
}
