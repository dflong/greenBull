package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _54 {

    int n, m;
    int up = 0, down = 0;
    int left = 0, right = 0;
    int[][] matrix;
    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        down = n - 1;
        right = m - 1;
        this.matrix = matrix;
        dfs();
        return res;
    }

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

    public static void main(String[] args) {
        int[][] max = new int[][] {
                {2,3,4},

        };
        _54 solution = new _54();
        System.out.println(solution.spiralOrder(max));
    }
}
