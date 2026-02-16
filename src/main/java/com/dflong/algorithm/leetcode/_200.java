package com.dflong.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _200 {

    int res = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

//    public int numIslands(char[][] grid) {
//        for (int i = 0; i < grid.length; i ++) {
//            for (int j = 0; j < grid[i].length; j ++) {
//                if (grid[i][j] == '1') {
//                    res ++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//
//        return res;
//    }
//    public void dfs(char[][] grid, int x, int y) {
//        for (int[] dir : dirs) {
//            int x1 = x + dir[0];
//            int y1 = y + dir[1];
//            if (x1 < 0 || x1 >= grid.length || y1 < 0 || y1 >= grid[0].length) continue;
//            if (grid[x1][y1] == '1') {
//                grid[x1][y1] = '2';
//                dfs(grid, x1, y1);
//            }
//        }
//    }


    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j ++) {
                if (grid[i][j] == '1') {
                    res ++;
                    bfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') continue;
                grid[x][y] = '2';
                q.add(new int[]{x, y});
            }
        }
    }


}
