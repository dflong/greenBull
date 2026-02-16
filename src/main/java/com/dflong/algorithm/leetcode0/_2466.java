package com.dflong.algorithm.leetcode0;

public class _2466 {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        int res = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }

            if (i >= low) {
                res = (res + dp[i]) % MOD;
            }
        }

        return res;
    }
}
