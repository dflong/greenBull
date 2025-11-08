package com.dflong.greenbull.leetcode;

public class _289 {

    public static void main(String[] args) {
        new _289().gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        });
    }

    public void gameOfLife(int[][] board) {
        int[][] move = new int[][] {
                {- 1, - 1}, {- 1, 0}, {- 1, 1},
                {0, - 1}, {0, 1},
                {1, - 1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {

                int cnt = 0;
                for (int k = 0; k < move.length; k ++) {
                    int x = i + move[k][0];
                    int y = j + move[k][1];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[i].length) {
                        continue;
                    }
                    cnt += (board[x][y] == 1 || board[x][y] == 3 ? 1 : 0);
                }

                if (board[i][j] == 1 && cnt < 2) {
                    board[i][j] = 3; // 死亡
                }
                else if (board[i][j] == 1 && (cnt == 3 || cnt == 2)) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && cnt > 3) {
                    board[i][j] = 3; // 死亡
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2; // 复活
                }
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
