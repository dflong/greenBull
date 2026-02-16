package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _73 {

    public void setZeroes(int[][] matrix) {
        // 标记
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> col = new ArrayList<>();

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    col.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < col.size(); i ++) {
            int[] ints = col.get(i);

            for (int j = 0; j < m; j ++) {
                matrix[j][ints[1]] = 0;
            }

            for (int j = 0; j < n; j ++) {
                matrix[ints[0]][j] = 0;
            }
        }
    }
}
