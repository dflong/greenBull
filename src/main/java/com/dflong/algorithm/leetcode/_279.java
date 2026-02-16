package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _279 {

    public static void main(String[] args) {
        new _279().numSquares(12);
    }

    public int numSquares(int n) {
        // n个数的平方和等于n的最少数量
        int[] dp = new int[n + 1];

        // 递推公式 dp[j] = min(dp[j], dp[j - num * num] + 1]

        // 初始化
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        // 遍历顺序
        for (int i = 0; i <= n; i ++) { // 先物品
            for (int j = 0; j * j <= i; j ++) { // 后背包
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
