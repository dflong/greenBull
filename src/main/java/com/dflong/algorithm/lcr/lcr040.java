package com.dflong.algorithm.lcr;

import java.util.Arrays;
import java.util.LinkedList;

public class lcr040 {

    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length(), max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
            max = Math.max(max, largestRectangleArea(dp[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int[] r = new int[heights.length];
        Arrays.fill(r, heights.length);

        // 柱子左边第一个比自己矮的，和右边第一个比自己矮的
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                r[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }

        int[] l = new int[r.length];
        Arrays.fill(l, - 1);
        stack.clear();
        for(int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                l[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }

        int max = 0;
        for (int i = 0; i < r.length; i++) {
            max = Math.max(max, (r[i] - l[i] - 1) * heights[i]);
        }

        return max;
    }
}
