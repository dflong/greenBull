package com.dflong.algorithm.leetcode;

import java.util.*;

public class _310 {

    public static void main(String[] args) {
        new _310().findMinHeightTrees(4, new int[][] {{1,0}, {1,2}, {1,3}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        // 生成邻接表
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            grid.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[0]] ++;
            degree[edge[1]] ++;
            grid.get(edge[0]).add(edge[1]);
            grid.get(edge[1]).add(edge[0]);
        }

        // bfs
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                res.add(cur);

                List<Integer> nexts = grid.get(cur);
                for (Integer next : nexts) {
                    degree[next] --;
                    if (degree[next] == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return res;
    }
}
