package com.dflong.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _391 {

    public static void main(String[] args) {
        new _391().isRectangleCover(new int[][] {
                {1,1,2,3},
                {1,3,2,4},
                {3,1,4,2},
                {3,2,4,4}
        });
    }

    public boolean isRectangleCover(int[][] rectangles) {
        // 找到左下、右上最大值 得到一个矩形 看是否等于 所有小矩形之和
        int a1 = Integer.MAX_VALUE, b1 = Integer.MAX_VALUE;
        int a2 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int mergeS = 0;
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], x2 = rectangle[2];
            int y1 = rectangle[1], y2 = rectangle[3];

            // 计算左下角
            if (x1 < a1 || y1 < b1) {
                a1 = x1;
                b1 = y1;
            }

            // 计算右上角
            if (x2 > a2 || y2 > b2) {
                a2 = x2;
                b2 = y2;
            }

            record(x1, y1);
            record(x1, y2);
            record(x2, y1);
            record(x2, y2);

            mergeS += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }

        int s = (a2 - a1) * (b2 - b1);
        // 面积不相等
        if (s != mergeS) return false;

        return set.size() == 4 &&
                set.contains(getKey(a1, b1)) &&
                set.contains(getKey(a2, b1)) &&
                set.contains(getKey(a1, b2)) &&
                set.contains(getKey(a2, b2));
    }

    public void record(int x, int y) {
        int key = getKey(x, y);
        if (set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }

    Set<Integer> set = new HashSet<>();
    public int getKey(int x, int y) {
        return x * 100000007 + y;
    }

}
