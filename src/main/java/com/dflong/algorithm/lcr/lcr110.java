package com.dflong.algorithm.lcr;

import java.util.*;

public class lcr110 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        this.graph = graph;

        path.add(0);
        backTrack(0);
        return res;
    }

    void backTrack(int idx) {
        if (idx == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph[idx]) {
            path.add(i);
            backTrack(i);
            path.remove(path.size() - 1);
        }
    }

    int n;
    int[][] graph;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
}
