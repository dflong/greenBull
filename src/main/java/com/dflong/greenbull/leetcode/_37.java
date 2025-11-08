package com.dflong.greenbull.leetcode;

public class _37 {

    public void solveSudoku(char[][] board) {
        this.board = board;
        backTracking();
    }

    char[][] board;

    public boolean backTracking() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k)) {
                            board[i][j] = k;
                            if (backTracking()) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int col, int row, int k) {
        // 行
        for (int i = 0; i < 9; i++) {
            if (board[col][i] == k) {
                return false;
            }
        }

        // 列
        for (int i = 0; i < 9; i++) {
            if (board[i][row] == k) {
                return false;
            }
        }

        // 3 * 3
        col = col / 3 * 3;
        row /= row / 3 * 3;
        for (int i = col; i < col + 3; i++) {
            for (int j = row; j < row + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
