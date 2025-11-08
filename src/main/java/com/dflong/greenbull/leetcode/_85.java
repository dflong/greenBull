package com.dflong.greenbull.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _85 {

    public static void main(String[] args) {
        new _85().maximalRectangle(new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }

    public int maximalRectangle(char[][] matrix) {
        // 转换成每一层向上看的矩形高度，然后运用_84的单调栈
        int m = matrix.length, n =  matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i ++) {
            max = Math.max(max, maxStack(dp[i]));
        }
        return max;
    }

    public int maxStack(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        Arrays.fill(left, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int top = stack.pop();
                left[top] = i;
            }
            stack.push(i);
        }

        stack.clear();
        int[] right = new int[n];
        Arrays.fill(right, - 1);
        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int top = stack.pop();
                right[top] = i;
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i ++) {
            max = Math.max(max, nums[i] * (left[i] - right[i] - 1));
        }

        return max;
    }
}
