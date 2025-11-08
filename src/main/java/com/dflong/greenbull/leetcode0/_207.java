package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207 {

    List<List<Integer>> edges;
    int[] inEdge;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        inEdge = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]); // [1, 0] 必须先完成0才能完成1, info[1] -> info[0]
            inEdge[info[0]]++; // 0的入度数量
        }

        Queue<Integer> queue = new LinkedList<>(); // 放的都是入度为0的点
        for (int i = 0; i < numCourses; i++) {
            if (inEdge[i] == 0) { // 入度为0
                queue.add(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited ++;
            Integer poll = queue.poll();
            for (int v : edges.get(poll)) { // edges.get(poll)以poll为出度的点，得到所有入度的点集合 `
                inEdge[v] --;
                if (inEdge[v] == 0) {
                    queue.add(v);
                }
            }
       }
        return visited == numCourses;
    }


    public static void main(String[] args) {
        _207 v = new _207();
        boolean b = v.canFinish1(2, new int[][]{{0, 1}});
        System.out.println();
    }


    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(); // index对外发射的边
        int[] inEdge = new int[numCourses]; // 入度边数量

        for (int i = 0; i < numCourses; i ++) {
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inEdge[info[0]] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (inEdge[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited ++;
            Integer poll = queue.poll();
            for (int i : edges.get(poll)) {
                inEdge[i] --;
                if (inEdge[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return visited == numCourses;
    }
}
