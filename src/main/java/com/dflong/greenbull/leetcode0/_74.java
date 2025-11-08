package com.dflong.greenbull.leetcode0;

public class _74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            } else if (x > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
