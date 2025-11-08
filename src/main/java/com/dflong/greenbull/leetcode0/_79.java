package com.dflong.greenbull.leetcode0;

public class _79 {

    public static void main(String[] args) {
        _79 v = new _79();

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean abcc = v.exist(board, "ABCESEEEFS");
        System.out.println();
    }

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
                    boolean dfs = dfs(i, j, 0, visited);
                    if (dfs) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int i, int j, int index, int[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (isValid(i, j) && board[i][j] == word.charAt(index)) {
            visited[i][j] = 1;
            boolean dfs = dfs(i + 1, j, index + 1, visited);
            boolean dfs1 = dfs(i - 1, j, index + 1, visited);
            boolean dfs2 = dfs(i, j + 1, index + 1, visited);
            boolean dfs3 = dfs(i, j - 1, index + 1, visited);
            visited[i][j] = 0;
            return dfs || dfs1 || dfs2 || dfs3;
        }

        return false;
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 0 ;
    }
}
