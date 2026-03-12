package com.dflong.algorithm.leetcode;

public class _498 {

    public static void main(String[] args) {
        new _498().findDiagonalOrder(new int[][]{
                {1, 2},
                {3, 4}
        });
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;

        int i = 0, j = 0;
        while (idx < m * n) {
            // 先递减i，递增j
            while (i >= 0 && j < n) {
                res[idx ++] = mat[i][j];
                i --;
                j ++;
            }
            i = 0; // 循环结束后i = -1 变成0
            if (j >= n) {
                j --;
                i ++;
            }

            // 后递减j，递增i
            while (j >= 0 && i < m) {
                res[idx ++] = mat[i][j];
                j --;
                i ++;
            }
            j = 0;
            if (i >= m) {
                i --;
                j ++;
            }
        }

        return res;
    }
}
