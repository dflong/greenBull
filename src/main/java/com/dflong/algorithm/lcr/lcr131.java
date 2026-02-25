package com.dflong.algorithm.lcr;

public class lcr131 {

    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= bamboo_len; i ++) {
            for (int j = 0; j < i; j ++) {
                int temp = Math.max(dp[i - j] * j, (i -j) * j);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[bamboo_len];
    }
}
