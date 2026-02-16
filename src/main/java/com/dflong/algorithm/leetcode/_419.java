package com.dflong.algorithm.leetcode;

public class _419 {

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    res ++;
                }
            }
        }

        return res;
    }

    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(char[][] board, int row, int col) {
        board[row][col] = '.';
        for (int[] dir : dirs) {
            int x = row + dir[0], y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == 'X') {
                dfs(board, x, y);
            }
        }
    }
}
