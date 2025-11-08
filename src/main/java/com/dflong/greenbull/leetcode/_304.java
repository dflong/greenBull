package com.dflong.greenbull.leetcode;

public class _304 {


}

class NumMatrix {

    int m = 0, n = 0;
    int[][] sum;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0) {
                    sum[i][j] = matrix[i][j];
                } else {
                    sum[i][j] = sum[i][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i ++) {
            res += sum[i][col2] - sum[i][col1] + matrix[i][col1];
        }
        return res;
    }
}
