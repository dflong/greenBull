package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _84 {

    public static void main(String[] args) {
        _84 v = new _84();
        int i = v.largestRectangleArea(new int[]{5,6,7,4,3});

    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 找右边比当前高度低的
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 找左边比当前高度低的
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = heights[i] * (right[i] - left[i] - 1);
            res = Math.max(res, cur);
        }
        return res;
    }
}
