package com.dflong.algorithm.leetcode;

import java.util.*;

/**
 * 优化版本Bellman_ford
 */
public class SPFA {

    public int minDis(int n, int[][] grid) {
        // 生成邻接表
        List<Edge>[] edges = new List[n + 1];
        Arrays.fill(edges, new ArrayList<Edge>());
        for (int[] row : grid) {
            edges[row[0]].add(new Edge(row[0], row[1], row[2]));
        }

        // 最多松弛n - 1次

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0; // 起点
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int[] count = new int[n + 1]; // 判断节点入度次数
        count[1] = 1;

        while (!queue.isEmpty()) { // 只对相连的点松弛，避免无效操作
            int cur = queue.poll();

            for (Edge edge : edges[cur]) {
                if (minDist[edge.r] > minDist[edge.l] + edge.val) {
                    minDist[edge.r] = minDist[edge.l] + edge.val;
                    count[edge.r] ++;
                    if (count[edge.r] == n) {
                        // 说明存在负权回路
                    }

                    if (!visited[edge.r]) {
                        visited[edge.r] = true;
                        queue.add(edge.r);
                    }
                }
            }
        }

        return minDist[n];
    }
}
