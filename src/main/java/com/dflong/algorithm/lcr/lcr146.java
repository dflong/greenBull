package com.dflong.algorithm.lcr;

import java.util.ArrayList;
import java.util.List;

public class lcr146 {

    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0) return new int[0];
        n = matrix.length; m = matrix[0].length;
        down = n - 1;
        right = m - 1;
        this.matrix = matrix;
        dfs();
        return res.stream().mapToInt(x -> x).toArray();
    }

    int n, m;
    int up = 0, down = 0;
    int left = 0, right = 0;
    int[][] matrix;
    List<Integer> res = new ArrayList<>();

    public void dfs(){
        if (left > right || up > down) return;
        for (int i = left; i <= right; i++) {
            res.add(matrix[up][i]);
        }
        up ++;

        for (int i = up; i <= down; i++) {
            res.add(matrix[i][right]);
        }
        right --;

        if (up <= down) {
            for (int i = right; i >= left; i --) {
                res.add(matrix[down][i]);
            }
        }
        down --;

        if (left <= right) {
            for (int i = down; i >= up; i --) {
                res.add(matrix[i][left]);
            }
        }
        left ++;
        dfs();
    }
}
