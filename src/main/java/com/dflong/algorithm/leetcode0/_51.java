package com.dflong.algorithm.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51 {


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        columns = new int[n];
        xie1 = new int[2 * n - 1];
        xie2 = new int[2 * n - 1];
        board = new int[n];
        dfs(0);
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    int[] columns, xie1, xie2; // 列， 45度斜线，135度斜线
    int n;
    int[] board;

    public void dfs(int row) {
        if (row == n) {
            buildRes();
            return;
        }

        for (int col = 0; col < n; col ++) {
            if (columns[col] == 1 || xie1[row + col] == 1 || xie2[row - col + n - 1] == 1) continue;
            columns[col] = 1;
            xie1[row + col] = 1;
            xie2[row - col + n - 1] = 1;
            board[row] = col;
            dfs(row + 1);
            columns[col] = 0;
            xie1[row + col] = 0;
            xie2[row - col + n - 1] = 0;
        }
    }

    public void buildRes() {
        List<String> temp = new ArrayList<>();
        for (int i : board) {
            char[] str = new char[n];
            Arrays.fill(str, '.');
            str[i] = 'Q';
            temp.add(new String(str));
        }
        res.add(temp);
    }
}
