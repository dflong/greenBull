package com.dflong.algorithm.lcr;

public class lcr129 {

    char[][] board;
    String word;

    int m, n;
    int[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new int[m][n];
                    boolean dfs = backTrack(i, j, 0, visited);
                    if (dfs) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean backTrack(int i, int j, int index, int[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (isValid(i, j) && board[i][j] == word.charAt(index)) {
            visited[i][j] = 1;
            boolean dfs = backTrack(i + 1, j, index + 1, visited);
            if (dfs) {
                return true;
            }
            boolean dfs1 = backTrack(i - 1, j, index + 1, visited);
            if (dfs1) {
                return true;
            }
            boolean dfs2 = backTrack(i, j + 1, index + 1, visited);
            if (dfs2) {
                return true;
            }
            boolean dfs3 = backTrack(i, j - 1, index + 1, visited);
            if (dfs3) {
                return true;
            }
            visited[i][j] = 0;
            return false;
        }

        return false;
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 0 ;
    }
}
