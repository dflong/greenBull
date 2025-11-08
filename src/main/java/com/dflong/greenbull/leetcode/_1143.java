package com.dflong.greenbull.leetcode;

public class _1143 {

    public static void main(String[] args) {
        new _1143().longestCommonSubsequence("bl", "yby");
    }

    /**
     *    a  c  e
     * a  1  1  1
     * b  1  1  1
     * c  1  2  2
     * d  1  2  2
     * e  1  2  3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        // i,j位置最长公共子序列
        int[][] dp = new int[n][m];

        // text1.charAt(i) == text2.charAt(j) dp[i][j] = dp[i - 1][j - 1] + 1
        // dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]

        // 初始化
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 遍历顺序
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

}
