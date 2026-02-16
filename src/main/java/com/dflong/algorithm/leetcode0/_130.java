package com.dflong.algorithm.leetcode0;

public class _130 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
        };
        _130 v = new _130();
        v.solve(board);
        System.out.println();
    }

    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dps(board, i, 0);
            dps(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dps(board, 0, i);
            dps(board, m - 1, i);
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dps(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'D';
        dps(board, x + 1, y);
        dps(board, x - 1, y);
        dps(board, x, y + 1);
        dps(board, x, y - 1);
    }
}
