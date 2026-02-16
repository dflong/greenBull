package com.dflong.algorithm.leetcode;

/**
 * 多源节点最短距离
 */
public class Floyd {

    public int minDist(int n, int[][] grid) {
        // 节点i,j经过[1, n]的节点的最短路径
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        // 递推公式
        // dp[i][j][k] = min(dp[i][j][k - 1], dp[i][k][k - 1] + dp[k][j][k - 1]);

        // 初始化
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= n; j ++) {
                for (int k = 0; k <= n; k ++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] row : grid) {
            int i = row[0];
            int j = row[1];
            int weight = row[2];

            dp[i][j][0] = weight;
            dp[j][i][0] = weight;
        }

        // 遍历顺序
        for (int k = 1; k <= n; k ++) {
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= n; j ++) {
                    dp[i][j][k] = Math.min(dp[i][j][k - 1], dp[i][k][k - 1] + dp[k][j][k - 1]);
                }
            }
        }

        return 0;
    }
}
