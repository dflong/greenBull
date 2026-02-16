package com.dflong.algorithm.lcr;

public class lcr105 {

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) { // 是岛屿
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
        for (int[] dir : dirs) { // 向四周发散
            int newX = x + dir[0];
            int newY = y + dir[1];

            // 越界
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
            // 不是岛屿
            if (grid[newX][newY] != 1) continue;
            dfs(grid, newX, newY);
        }
    }
}
