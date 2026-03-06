package com.dflong.algorithm.lcr;

import java.util.Arrays;
import java.util.LinkedList;

public class lcr039 {

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
