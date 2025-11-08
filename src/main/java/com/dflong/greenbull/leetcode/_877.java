package com.dflong.greenbull.leetcode;

public class _877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j] 石子数量之差
        int[][] dp = new int[n][n];

        // 递推公式 dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])

        // 初始化
        for (int i = 0; i < n; i ++) {
            dp[i][i] = piles[i];
        }

        // 遍历顺序 i倒序 j正序
        for (int i = n - 1; i >= 0; i --) {
            for (int j = i + 1; j < n; j ++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
