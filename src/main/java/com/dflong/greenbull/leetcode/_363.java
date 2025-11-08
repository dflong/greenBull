package com.dflong.greenbull.leetcode;

import java.util.TreeSet;

public class _363 {

    public static void main(String[] args) {
        new _363().maxSumSubmatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 2);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        // 生成二维前缀和
        int m = matrix.length, n =  matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                // 左边 + 上边 - 左上角 + 本身位置
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // 上边界
        for (int top = 1; top <= m; top ++) {
            // 下边界
            for (int bottom = top; bottom <= m; bottom ++) {
                TreeSet<Integer> rightSet = new TreeSet<>(); // 右边界
                rightSet.add(0);

                for (int r = 1; r <= n; r ++) {
                    int right = sum[bottom][r] - sum[top - 1][r]; // 生成一维数组前缀和
                    Integer l = rightSet.ceiling(right - k); // (右 - 左) == k
                    if (l != null) { // 左边界
                        max = Math.max(max, right - l);
                    }
                    rightSet.add(right);
                }
            }
        }

        return max;
    }
}
