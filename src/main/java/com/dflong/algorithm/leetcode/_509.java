package com.dflong.algorithm.leetcode;

public class _509 {

    public int fib(int n) {
        if (n == 0) return 0;
        // 确定dp数组含义 dp[n]第n个斐波那契数
        int[] dp = new int[n + 1];
        // dp推导公式 dp[n] = dp[n - 1] + dp[n - 2]

        // 初始化
        dp[0] = 0;
        dp[1] = 1;

        // 遍历顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 举例

        return dp[n];
    }
}
