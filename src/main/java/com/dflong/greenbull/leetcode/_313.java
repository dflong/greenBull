package com.dflong.greenbull.leetcode;

import java.util.Arrays;

public class _313 {

    public static void main(String[] args) {
        new _313().nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }

    // 参考_264
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        long[] dp = new long[n + 1]; // 第i位的丑数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        int[] num = new int[primes.length]; // 质数因子
        Arrays.fill(num, 1);

        for (int k = 2; k <= n; k ++) {
            for (int i = 0; i < primes.length; i ++) {
                dp[k] = Math.min(dp[k], dp[num[i]] * primes[i]);
            }
            for (int i = 0; i < primes.length; i ++) {
                if (dp[k] == dp[num[i]] * primes[i]) {
                    num[i] ++;
                }
            }
        }

        return (int) dp[n];
    }
}
