package com.dflong.greenbull.leetcode;

public class _59 {

    public int[][] generateMatrix(int n) {
        this.n = n;
        this.matrix = new int[n][n];
        dfs(0, n - 1, 0, n - 1);
        return matrix;
    }
    int num = 1;
    int n = 0;
    int [][] matrix;

    public void dfs(int left, int right, int top, int bottom) {
        // 奇数
        if (num == n * n){
            matrix[top][left] = num;
            return;
        }

        // 偶数
        if (left == right + 1 && top == bottom + 1) {
            return;
        }

        for (int i = left; i <= right; i++) {
            matrix[top][i] = num ++;
        }

        for (int i = top + 1; i <= bottom; i++) {
            matrix[i][right] = num ++;
        }

        for (int i = right - 1; i >= left; i--) {
            matrix[bottom][i] = num ++;
        }

        for (int i = bottom - 1; i > top; i--) {
            matrix[i][left] = num ++;
        }

        left ++;
        right --;
        top ++;
        bottom --;
        dfs(left, right, top, bottom);
    }
}
