package com.dflong.algorithm.leetcode;

public class _695 {

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    max = Math.max(max, num);
                    num = 0;
                }
            }
        }

        return max;
    }

    int max = 0, num = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int[][] grid, int x, int y) {
        num ++;
        grid[x][y] = 2;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
            if (grid[newX][newY] != 1) continue;
            dfs(grid, newX, newY);
        }
    }
}
