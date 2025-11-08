package com.dflong.greenbull.leetcode0;

public class _59 {

    public static void main(String[] args) {
        new _59().generateMatrix(1);
    }

    public int[][] generateMatrix(int n) {
        this.matrix = new int[n][n];
        this.n = n;
        dfs(0, n - 1, 0, n - 1);
        return this.matrix;
    }

    int[][] matrix;
    int num = 1;
    int n;

    public void dfs(int left, int right, int high, int low) {
        // 奇数
        if (n * n == num) {
            matrix[left][left] = num;
            return;
        }
        // 偶数
        if (left == right + 1 && high == low + 1) {
            return;
        }

        for (int i = left; i <= right; i ++) {
            matrix[high][i] = num ++;
        }

        for (int i = high + 1; i <= low; i ++) {
            matrix[i][right] = num ++;
        }

        for (int i = right - 1; i >= left; i --) {
            matrix[low][i] = num ++;
        }

        for (int i = low - 1; i >= high + 1; i--) {
            matrix[i][left] = num ++;
        }

        left ++;
        right --;
        high ++;
        low --;

        dfs(left, right, high, low);
    }
}
