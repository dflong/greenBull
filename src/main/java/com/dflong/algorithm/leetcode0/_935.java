package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _935 {

    public int knightDialer(int n) {
        int MOD = 1000000007;
        long[] dp = new long[10];
        Arrays.fill(dp, 1);
        while (n > 0) {
            long[] f = new long[10];
            f[0] = (dp[4] + dp[6]) % MOD;
            f[1] = (dp[6] + dp[8]) % MOD;
            f[2] = (dp[7] + dp[9]) % MOD;
            f[3] = (dp[4] + dp[8]) % MOD;
            f[4] = (dp[0] + dp[3] + dp[9]) % MOD;

            f[6] = (dp[0] + dp[1] + dp[7]) % MOD;
            f[7] = (dp[2] + dp[6]) % MOD;
            f[8] = (dp[1] + dp[3]) % MOD;
            f[9] = (dp[2] + dp[4]) % MOD;

            dp = f;
            n --;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (int) ((sum + dp[i]) % MOD);
        }

        return sum;
    }

}
