package com.dflong.greenbull.leetcode;

import java.util.Arrays;

/**
 * 起点到终点的最小距离
 */
public class Bellman_ford {

    public int minDis(int n, int[][] grid) {
        // 最多松弛n - 1次

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[1] = 0; // 起点

        for (int i = 1; i < n; i ++ ) { // 最多n - 1次
            for (int[] edge : grid) { // 对所有边松弛
                int f = edge[0];
                int to = edge[1];
                int val = edge[2];

                // 起点不能是未更新过的
                if (f != Integer.MAX_VALUE && minDist[to] > minDist[f] + val) {
                    minDist[to] = minDist[f] + val;
                }
            }
        }

        // 判断是否存在负权回路
//        for (int i = 1; i <= n; i ++ ) { // 最多n - 1次
//            for (int[] edge : grid) { // 对所有边松弛
//                int f = edge[0];
//                int to = edge[1];
//                int val = edge[2];
//
//                // 起点不能是未更新过的
//                if (i < n) {
//                    if (f != Integer.MAX_VALUE && minDist[to] > minDist[f] + val) {
//                        minDist[to] = minDist[f] + val;
//                    }
//                } else {
//                    if (f != Integer.MAX_VALUE && minDist[to] > minDist[f] + val) {
//                       // 第n次minDist还是发生了改变说明存在负权回路
//                    }
//                }
//            }
//        }

        return minDist[n];
    }
}
