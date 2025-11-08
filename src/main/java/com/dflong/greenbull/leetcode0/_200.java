package com.dflong.greenbull.leetcode0;

public class _200 {

    public int numIslands(char[][] grid) {
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                num += dfs(grid, i, j);
            }
        }

        return num;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j)) {
            return 0;
        }

        if(grid[i][j] != '1') {
            return 0;
        }
        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);

        return 1;
    }

    private boolean isValid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

}
