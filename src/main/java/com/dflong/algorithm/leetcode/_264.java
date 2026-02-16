package com.dflong.algorithm.leetcode;

public class _264 {

    public static void main(String[] args) {
        new _264().nthUglyNumber(10);
    }

    public int nthUglyNumber(int n) {
        // 第i位的丑数
        int[] dp = new int[n + 1];

        // dp[i] = min(a, b, c)

        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i ++) {
            int a1 = dp[a] * 2;
            int b1 = dp[b] * 3;
            int c1 = dp[c] * 5;

            dp[i] = Math.min(Math.min(b1, a1), c1);

            if (dp[i] == a1) {
                a ++;
            }
            if (dp[i] == b1) {
                b ++;
            }
            if (dp[i] == c1) {
                c ++;
            }
        }

        return dp[n];
    }
}
