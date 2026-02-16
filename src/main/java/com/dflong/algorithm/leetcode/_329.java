package com.dflong.algorithm.leetcode;

public class _329 {

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j ++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }

    int[][] dp;
    int max = 0;
    int[][] matrix;

    public int dfs(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int maxLen = 1;
        if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
            maxLen = Math.max(maxLen, 1 + dfs(i + 1, j)); // 更新[i,j]最大长度
        }
        if (j + 1 < matrix[i].length && matrix[i][j] < matrix[i][j + 1]) {
            maxLen = Math.max(maxLen, 1 + dfs(i, j + 1));
        }
        if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
            maxLen = Math.max(maxLen, 1 + dfs(i - 1, j));
        }
        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
            maxLen = Math.max(maxLen, 1 + dfs(i, j - 1));
        }

        dp[i][j] = maxLen;
        return dp[i][j];
    }
}
