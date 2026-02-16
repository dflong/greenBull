package com.dflong.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        new _54().spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;

        dfs(0, n - 1, 0, m - 1);
        return res;
    }

    List<Integer> res;
    int m, n;
    int[][] matrix;

    public void dfs(int left, int right, int top, int bottom) {

        if (left > right || top > bottom) {
            return;
        }

        for (int i = left; i <= right; i++) {
            res.add(matrix[top][i]);
        }
        if (res.size() == m * n) return;
        for (int i = top + 1; i <= bottom; i++) {
            res.add(matrix[i][right]);
        }
        if (res.size() == m * n) return;
        for (int i = right - 1; i >= left; i--) {
            res.add(matrix[bottom][i]);
        }
        if (res.size() == m * n) return;

        for (int i = bottom - 1; i > top; i--) {
            res.add(matrix[i][left]);
        }
        if (res.size() == m * n) return;
        dfs(left + 1, right - 1, top + 1, bottom - 1);
    }
}
