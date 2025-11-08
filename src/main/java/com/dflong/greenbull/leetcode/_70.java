package com.dflong.greenbull.leetcode;

public class _70 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        // dp[n]数组含义 第n阶台阶有多少种方法
        int[] dp = new int[n + 1];

        // 推导公式 dp[n] = dp[n - 1] + dp[n - 2]

        // 初始化
        dp[1] = 1;
        dp[2] = 2;

        // 遍历顺序
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 举例

        return dp[n];
    }

    // n阶楼梯一次可以爬1-m阶
    public int climbStairs(int n, int m) {
        // n阶楼梯一次可以爬1-m阶的排列数
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int j = 1; j <= n; j ++) {
            for (int i = 1; i <= m; i ++) {
                if (j >= i) {
                    dp[j] += dp[j - i];
                }
            }
        }

        return dp[n];
    }
}
