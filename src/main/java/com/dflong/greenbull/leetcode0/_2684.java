package com.dflong.greenbull.leetcode0;

public class _2684 {

    public static void main(String[] args) {
        new _2684().maxMoves(new int[][]{
                {266,18,114,208,14,133,248,68,185,27,86,236},
                {272,192,226,97,244,202,18,28,150,183,166,167},
                {64,211,163,292,12,16,211,158,133,272,275,12},
                {276,208,94,264,44,180,293,50,84,167,34,249},
                {152,283,205,142,276,273,244,180,19,14,83,238},
                {237,240,26,38,299,143,219,7,147,25,129,219},
                {268,58,46,211,16,296,173,192,91,75,99,151}
        });
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int j = n - 1; j >= 1; j--) {
            for (int i = 0; i < m; i++) {
                if (i == 0) { // 首行
                    if (grid[i][j] > grid[i][j - 1]) {
                        dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + 1);
                    }
                    if (grid[i][j] > grid[i + 1][j - 1]) {
                        dp[i + 1][j - 1] = Math.max(dp[i + 1][j - 1], dp[i][j] + 1);
                    }
                } else if (i == m - 1) { // 尾行
                    if (grid[i][j] > grid[i][j - 1]) {
                        dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + 1);
                    }
                    if (grid[i][j] > grid[i - 1][j - 1]) {
                        dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], dp[i][j] + 1);
                    }
                } else {
                    if (grid[i][j] > grid[i][j - 1]) {
                        dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + 1);
                    }
                    if (grid[i][j] > grid[i + 1][j - 1]) {
                        dp[i + 1][j - 1] = Math.max(dp[i + 1][j - 1], dp[i][j] + 1);
                    }
                    if (grid[i][j] > grid[i - 1][j - 1]) {
                        dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], dp[i][j] + 1);
                    }
                }

            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
