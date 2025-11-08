package com.dflong.greenbull.leetcode;

import java.util.Random;

public class _478 {

    class Solution {

        double r, x, y;
        Random rand = new Random();

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        // 在正方形范围内生成，结果是否在圆内
        public double[] randPoint() {
            while (true) {
                double x1 = rand.nextDouble() * 2 * r - r;
                double y1 = rand.nextDouble() * 2 * r - r;
                if (x1 * x1 + y1 * y1 <= r * r) {
                    return new double[]{x1 + x, y1 + y};
                }
            }
        }
    }
}
