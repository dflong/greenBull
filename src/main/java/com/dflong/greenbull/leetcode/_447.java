package com.dflong.greenbull.leetcode;

public class _447 {

    public static void main(String[] args) {
        new _447().numberOfBoomerangs(new int[][] {
                {0,0},
                {1,0},
                {2,0},
        });
    }

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == j) continue;
                long d = (long) (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (long) (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                for (int k = 0; k < n; k ++) {
                    if (i == k || j == k) continue;
                    long d1 = (long) (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (long) (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]);
                    if (d == d1) {
                        res += 1;
                    }
                }
            }
        }

        return res;
    }
}
