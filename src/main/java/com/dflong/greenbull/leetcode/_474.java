package com.dflong.greenbull.leetcode;

public class _474 {

    // 一维数组版本（有两个维度）
    public int findMaxForm(String[] strs, int m, int n) {
        // m个0 n个1的最大子集数量
        int[][] dp = new int[m + 1][n + 1];

        // 递推公式 dp[i][j] = max(dp[i][j], dp[i - m][j - n] + 1)

        // 初始化

        // 遍历顺序
        for (String str : strs) {
            int num0 = 0, num1 = 0;
            for (int i = 0; i < str.length(); i ++) {
                char c = str.charAt(i);
                if (c == '0') {
                    num0 ++;
                } else {
                    num1 ++;
                }
            }

            for (int i = m; i >= 0; i --) {
                for (int j = n; j >= 0; j --) {
                    if (i >= num0 && j >= num1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - num0][j - num1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
