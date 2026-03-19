package com.dflong.algorithm.leetcode0;

public class _3070 {

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
                if (i != 1 && j != 1 && preSum[i][j] < k) {
                    res ++;
                }
            }
        }
        return res;
    }
}
