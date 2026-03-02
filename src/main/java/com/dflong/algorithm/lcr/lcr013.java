package com.dflong.algorithm.lcr;

public class lcr013 {

    class NumMatrix {

        int m, n;
        int[][] sum, ma; // 前缀和

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            sum = new int[m][n]; // 每行的前缀和
            ma = matrix;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        sum[i][j] = matrix[i][j];
                    } else  {
                        sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum1 = 0;
            for (int i = row1; i <= row2; i++) {
                sum1 += sum[i][col2] - sum[i][col1] + ma[i][col1];
            }
            return sum1;
        }
    }
}
