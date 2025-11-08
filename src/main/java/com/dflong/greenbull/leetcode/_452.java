package com.dflong.greenbull.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452 {

    public int findMinArrowShots(int[][] points) {
        int res = 1;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i -1][1]) { // 有重叠
                res ++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i-1][1]); // 更新最小右边界
            }
        }
        return res;
    }
}
