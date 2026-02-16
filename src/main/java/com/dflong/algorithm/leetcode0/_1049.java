package com.dflong.algorithm.leetcode0;

public class _1049 {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j --) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }

    public int lastStoneWeightII1(int[] stones) {
        int n = stones.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }

        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i <= target; i++) {
            if (stones[0] <= i) {
                dp[0][i] = stones[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - dp[n - 1][target] - dp[n - 1][target];
    }

}
