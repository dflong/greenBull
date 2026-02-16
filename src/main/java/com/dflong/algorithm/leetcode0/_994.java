package com.dflong.algorithm.leetcode0;

import java.util.LinkedList;
import java.util.Queue;

public class _994 {

    public static void main(String[] args) {
        _994 v = new _994();
        int i = v.orangesRotting(new int[][]{
                {0, 2}
        });
        System.out.println();
    }

    int m, n;

    public int orangesRotting(int[][] grid) {

        // 放入队列
        m = grid.length;
        n = grid[0].length;
        int count = 0; // 新鲜橘子的数量
        int min = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count ++;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for (int k = 0; k < 4; k++) {
                    if (isValid(i + 1, j) && grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        q.add(new int[]{i + 1, j});
                        count --;
                    } else if (isValid(i - 1, j) && grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        q.add(new int[]{i - 1, j});
                        count --;
                    } else if (isValid(i, j - 1) && grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                        q.add(new int[]{i, j - 1});
                        count --;
                    } else if (isValid(i, j + 1) && grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        q.add(new int[]{i, j + 1});
                        count --;
                    }
                }
                size --;
            }
            min ++;
        }

        if (count > 0) return -1;
        return Math.max(min - 1, 0);
    }

    public boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
