package com.dflong.greenbull.leetcode;

public class _463 {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    int num = 0;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                num ++;
                continue;
            }
            if (grid[newX][newY] == 0) {
                num ++;
                continue;
            }
            if (grid[newX][newY] != 1) {
                continue;
            }
            dfs(grid, newX, newY);
        }
    }
}
