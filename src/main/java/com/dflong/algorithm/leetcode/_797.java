package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _797 {

    public static void main(String[] args) {
        new _797().allPathsSourceTarget(new int[][] {
                {1,2},
                {3},
                {3},
                {}
        });
    }

    List<List<Integer>> res =  new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        path.add(0);
        backTrack(0);
        return res;
    }

    public void backTrack(int idx) {
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

//    List<List<Integer>> res =  new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    int n;
//    int[][] graph;

    // graph 邻接矩阵
//    public void backTrack(int idx, int[][] graph) {
//        if (idx == n - 1) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (graph[idx][i] == 1) {
//                path.add(i);
//                backTrack(i, graph);
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//
//    public void createGraph(int[][] graph) {
//        this.graph = new int[n][n];
//
//        for (int i = 0; i < n; i ++) {
//            for (int j = 0; j < graph[i].length; j ++) {
//                this.graph[i][graph[i][j]] = 1;
//            }
//        }
//    }

//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        this.n = graph.length;
//        createLinkedList(graph);
//        path.add(0);
//        backTrack(0);
//        return res;
//    }
//
//    public void backTrack(int idx) {
//        if (idx == n - 1) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i : list.get(idx)) {
//            path.add(i);
//            backTrack(i);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    List<List<Integer>> res =  new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    int n;
//    List<LinkedList<Integer>> list = new ArrayList<>(); // 邻接表
//
//    // 邻接表
//    public void createLinkedList(int[][] graph) {
//        for (int i = 0; i < graph.length; i++) {
//            list.add(new LinkedList<>());
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//           for (int j = 0; j < graph[i].length; j++) {
//               list.get(i).add(graph[i][j]);
//           }
//        }
//    }
}
