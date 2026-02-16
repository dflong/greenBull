package com.dflong.algorithm.leetcode0;

public class _72 {

    public static void main(String[] args) {
        new _72().minDistance("", "");
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        boolean ihave = false, jhave = false;
        if (word1.charAt(0) == word2.charAt(0)) {
            dp[0][0] = 0;
            ihave = true;
            jhave = true;
        } else {
            dp[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (!ihave && word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = dp[i - 1][0];
                ihave = true;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (!jhave && word1.charAt(0) == word2.charAt(j)) {
                dp[0][j] = dp[0][j - 1];
                jhave = true;
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
