package com.dflong.algorithm.lcr;

public class lcr097 {

    public int numDistinct(String s, String t) {
        int MOD = (int) 1e9 + 7;
        int m = s.length(), n = t.length();
        // i，j位置子序列的数量
        int[][] dp = new int[m + 1][n + 1]; // 包含俩个前导""

        // 初始化
        for (int i = 0; i <= m; i ++) {
            dp[i][0] = 1; // t的空字符串都可以构成s
        }
        // s的空字符串都不可以构成t

        // 遍历顺序
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 由左上角，上角得来
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
