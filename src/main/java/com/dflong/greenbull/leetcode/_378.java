package com.dflong.greenbull.leetcode;

public class _378 {

    // 从左到右，从上到下递增
    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;

        int l = matrix[0][0], r = matrix[row - 1][col - 1];
        while (l < r) {
            mid = l + (r - l) / 2;
            int count = getCnt();
            if (count < k) { // 比mid小的只有cnt个比k少，说明在mid的右边
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int getCnt() {
        int cnt = 0;
        // 从左下角开始遍历
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1; // 这一列都小于mid
                j ++;
            } else {
                i --; // 往上一行走
            }
        }
        return cnt;
    }

    int row, col, mid;
    int[][] matrix;
}
