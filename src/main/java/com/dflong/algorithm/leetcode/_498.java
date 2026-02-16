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
        int size = m * n;

        int[] res = new int[size];
        int idx = 0;

        int i = 0, j = 0;
        int col = 0, row = 0;
        while (size -- > 0) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                col ++;
                i = col;
                j = 0;

                if (i >= m) {
                    i = m - 1;
                    row ++;
                    j = row;
                }
            }
            res[idx ++] = mat[i][j];
            i --; j ++;
        }

        return res;
    }
}
