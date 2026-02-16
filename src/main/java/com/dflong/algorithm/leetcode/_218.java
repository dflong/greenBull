package com.dflong.algorithm.leetcode;

import java.util.*;

public class _218 {

    public static void main(String[] args) {
        new _218().getSkyline(new int[][] {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        });
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();

        List<int[]> building = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = {buildings[i][0], - buildings[i][2]};
            int[] c = {buildings[i][1], buildings[i][2]};
            building.add(b);
            building.add(c);
        }

        // 按照左坐标排序, 相同时按照高度
        Collections.sort(building, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        pq.add(0); // 为了加入高度为0
        int pre = 0;

        for (int[] build : building) {
            int point = build[0], height = build[1];

            if (height < 0) {
                // 左端点加入
                pq.add(- height);
            } else {
                // 右端点删除
                pq.remove(height);
            }

            int cur = pq.peek();
            if (!pq.isEmpty() && pre != cur) {
                res.add(Arrays.asList(point, cur));
                pre = cur;
            }
        }

        return res;
    }
}
