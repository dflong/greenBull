package com.dflong.algorithm.leetcode0;

public class _392 {

    // 求最长公共子序列
    public static boolean isSubsequence(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        int res = 0;
        int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > res) res = dp[i][j];
            }
        }
        return res == charArray1.length;
    }
}
