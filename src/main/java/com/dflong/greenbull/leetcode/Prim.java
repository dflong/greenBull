package com.dflong.greenbull.leetcode;

import java.util.Arrays;

/**
 * 最小生成树: 把所有点连起来的最小成本
 */
public class Prim {

    public int minDist(int[][] edges) {
        // 生成邻接矩阵
        int n = edges.length;
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
            for (int j = 0; j < edges[i].length; j ++) {
                grid[i][j] = edges[i][j];
                grid[j][i] = edges[i][j];
            }
        }

        int[] minDist = new int[n + 1]; // 最小生成数组 保存到生成数组的距离
        Arrays.fill(minDist, 10000);
        boolean [] visited = new boolean[n + 1];
        for (int i = 0; i < n; i ++) { // 为了循环n - 1次
            // 1. 寻找距离最小生成树最短的结点
            int minVal = Integer.MAX_VALUE;
            int cur = - 1; // 当前节点
            for (int j = 0; j < n; j ++) {
                // 选取最小生成数组
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }

            // 2. 加入最小生成树
            visited[cur] = true;

            // 3. 更新非生成树到生成树的距离
            for (int j = 1; j <= n; j ++) {
                // 与当前节点相接的点距离小于最小生成数组的值就更新
                if (!visited[j] && grid[cur][j] < minDist[j]) {
                    minDist[j] = grid[cur][j];
                }
            }
        }

        int res = 0;
        for (int i = 2; i <= n; i ++) {
            res += minDist[i];
        }
        return res;
    }
}
