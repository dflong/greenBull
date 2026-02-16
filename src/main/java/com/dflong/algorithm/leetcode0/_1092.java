package com.dflong.algorithm.leetcode0;

public class _1092 {

    public static void main(String[] args) {
        new _1092().shortestCommonSupersequence("abac", "cab");
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        lcs(str1, str2);
        char[] s1 = (str1).toCharArray();
        char[] s2 = (str2).toCharArray();
        int m = s1.length - 1, n = s2.length - 1;
        StringBuilder sb = new StringBuilder();
        while (m > 0 || n > 0) {
            if (m == 0) {
                sb.append(s2[n --]);
            } else if (n == 0) {
                sb.append(s1[m --]);
            } else {
                if (s1[m] == s2[n]) {
                    sb.append(s1[m - 1]);
                    m --; n --;
                } else if (dp[m][n] == dp[m - 1][n]) {
                    sb.append(s1[m --]);
                } else {
                    sb.append(s2[n --]);
                }
            }
        }

        return sb.reverse().toString();
    }

    int[][] dp;
    public void lcs(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
