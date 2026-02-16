package com.dflong.algorithm.leetcode;

import java.util.*;

public class _210 {

    public static void main(String[] args) {
        new _210().findOrder(4, new int[][] {
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        });
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序 将图按照线性排序

        // 生成入度
        int[] degrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            degrees[pre[0]] ++;
            List<Integer> orDefault = map.getOrDefault(pre[1], new ArrayList<>());
            orDefault.add(pre[0]);
            map.put(pre[1], orDefault);
        }

        // 寻找入度为0的
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (degrees[i] == 0) queue.add(i);
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[i ++] = poll;
            List<Integer> courses = map.get(poll);
            if (courses == null) continue;
            for (int course : courses) {
                if (-- degrees[course] == 0) {
                    queue.add(course);
                }
            }
        }

        return i == numCourses ? res: new int[]{};
    }

}
