package com.dflong.algorithm.leetcode;

import java.util.*;

public class _417 {

    public static void main(String[] args) {
        new _417().pacificAtlantic(new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        });
    }

    int m, n;
    int[][] heights;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] pacific, atlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length; n = heights[0].length;
        this.heights = heights;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        // 从边界开始往高处搜索
        for (int i = 0; i < m; i ++) {
            dfs(i, 0, pacific);
            dfs(i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j ++) {
            dfs(0, j, pacific);
            dfs(m - 1, j, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>(); // 结果
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, boolean[][] ocean) {
        if (ocean[i][j]) return;

        ocean[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && heights[x][y] >= heights[i][j]) {
                dfs(x, y, ocean);
            }
        }
    }
}
