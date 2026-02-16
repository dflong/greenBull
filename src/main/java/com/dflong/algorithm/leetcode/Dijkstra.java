package com.dflong.algorithm.leetcode;

import java.util.*;

/**
 * 从起点到终点的最小距离
 */
public class Dijkstra {

    // 朴素版本
    public int minDis(int n, int[][] grid) {
        boolean[] visited = new boolean[n + 1]; // 从1开始

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        int start = 1;
        minDist[start] = 0;

        for (int i = 1; i <= n; i ++) {
            // 1. 距源点最近且未标记
            int cur = 0;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j ++) {
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }

            // 2. 标记
            visited[cur] = true;

            // 3. 更新距源点的最小距离
            for (int j = 1; j <= n; j ++) {
                if (!visited[j] && grid[cur][j] != Integer.MAX_VALUE && grid[cur][j] + minDist[cur] < minDist[j]) {
                    minDist[j] = grid[cur][j] + minDist[cur]; // todo 与prim的区别 : prim更新到已标记点距离
                }
            }
        }

        return minDist[n] == Integer.MAX_VALUE ? - 1 : minDist[n];
    }

    // 堆优化版本
    public int minDis_heap(int n, int[][] grid) {
        // 生成邻接表
        List<Edge>[] nums = new List[n + 1];
        Arrays.fill(nums, new ArrayList<Integer>());

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                nums[i].add(new Edge(i, j , grid[i][j]));
            }
        }

        // 存储从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // 记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.second));
        int start = 1;  // 起点
        int end = n;    // 终点

        pq.add(new Pair<>(start, 0));

        while (!pq.isEmpty()) {
            // 1. 距离源点近未标记过
            Pair<Integer, Integer> cur = pq.poll();
            if (visited[cur.first]) continue;

            // 2. 标记
            visited[cur.first] = true;

            // 3. 更新非标记点距离
            for (Edge edge : nums[cur.first]) {
                if (!visited[edge.r] && minDist[cur.first] + edge.val < minDist[edge.r]) {
                    minDist[edge.r] = edge.val + minDist[cur.first]; // 更新到源点的距离
                }
            }
        }

        return minDist[end] == Integer.MAX_VALUE ? - 1 : minDist[end];
    }
}

