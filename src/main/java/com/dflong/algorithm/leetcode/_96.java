package com.dflong.algorithm.leetcode;

public class _96 {

    public static void main(String[] args) {
        new _96().numTrees(3);
    }

    public int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        // n阶数有多少二叉搜索树
        int[] dp = new int[n + 1];

        // 递推公式 dp[n] += dp[i] * dp[i - j - 1]

        // 初始化
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // 遍历顺序
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }

        return dp[n];
    }
}
