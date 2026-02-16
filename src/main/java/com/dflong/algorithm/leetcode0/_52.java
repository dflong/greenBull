package com.dflong.algorithm.leetcode0;

public class _52 {

    public int totalNQueens(int n) {
        this.n = n;
        cols = new int[n];
        xie1 = new int[n * 2 - 1];
        xie2 = new int[n * 2 - 1];
        dfs(0);
        return res;
    }

    public void dfs(int row) {
        if (row == n) {
            res ++; // 51与52的区别，组装棋盘或数量
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i] == 1 || xie1[row + i] == 1 || xie2[row - i + n - 1] == 1) continue;
            cols[i] = 1;
            xie1[row + i] = 1;
            xie2[row - i + n - 1] = 1;
            dfs(row + 1);
            cols[i] = 0;
            xie1[row + i] = 0;
            xie2[row - i + n - 1] = 0;
        }
    }

    int n;
    int[] cols, xie1, xie2;
    int res = 0;
}
