package com.dflong.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _407 {

    public static void main(String[] args) {
        new _407().trapRainWater(new int[][] {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        });
    }

    public int trapRainWater1(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        // 使用优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[2]));

        boolean[][] visited = new boolean[m][n];
        // 先加入边界
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    visited[i][j] = true;
                    pq.offer(new int[] {i, j, heightMap[i][j]});
                }
            }
        }

        int res = 0;
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0], y = top[1], h = top[2];
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    if (heightMap[newX][newY] < h) {
                        res += h - heightMap[newX][newY];
                    }
                    pq.offer(new int[] {newX, newY, Math.max(heightMap[newX][newY], h)});
                }
            }
        }
        return res;
    }

    // dp 水会流出
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        // 二维数组 两个方向做动态规划
        int[][] leftMax = new int[m][n];
        int[][] rightMax = new int[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0) {
                    leftMax[i][j] = heightMap[i][j];
                } else {
                    leftMax[i][j] = Math.max(leftMax[i][j - 1], heightMap[i][j]);
                }
            }

            for (int j = n - 1; j >= 0; j --) {
                if (j == n - 1) {
                    rightMax[i][j] = heightMap[i][j];
                } else {
                    rightMax[i][j] = Math.max(rightMax[i][j + 1], heightMap[i][j]);
                }
            }
        }

        int[][] highMax = new int[m][n];
        int[][] lowMax = new int[m][n];

        for (int j = 0; j < n; j ++) {
            for (int i = 0; i < m; i ++) {
                if (i == 0) {
                    highMax[i][j] = heightMap[i][j];
                } else {
                    highMax[i][j] = Math.max(highMax[i - 1][j], heightMap[i][j]);
                }
            }

            for (int i = m - 1; i >= 0; i --) {
                if (i == m - 1) {
                    lowMax[i][j] = heightMap[i][j];
                } else {
                    lowMax[i][j] = Math.max(lowMax[i + 1][j], heightMap[i][j]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                // 四周最小值
                int min = Math.min(Math.min(leftMax[i][j], rightMax[i][j]), Math.min(highMax[i][j], lowMax[i][j]));
                int v = min - heightMap[i][j];
                res += v;
            }
        }

        return res;
    }
}
