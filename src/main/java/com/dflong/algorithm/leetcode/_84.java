package com.dflong.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

//@Service
public class _84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] rightHeight = new int[n];
        Arrays.fill(rightHeight, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rightHeight[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();

        int[] leftHeight = new int[n];
        Arrays.fill(leftHeight, - 1);
        for (int i = n - 1; i >= 0; i --) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                leftHeight[stack.pop()] = i;
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i ++) {
            max = Math.max(max, heights[i] * (rightHeight[i] - leftHeight[i] - 1));
        }

        return max;
    }

    public static void main(String[] args) {
        // [1, 6, 4, 4, 6, 6]
        // [-1, -1, 1, 2, 1, 4]
        new _84().largestRectangleArea(new int[] {2,1,5,6,2,3});
    }

}
