package com.dflong.algorithm.lcr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class lcr183 {

    public int[] maxAltitude(int[] heights, int limit) {
        if (heights == null || heights.length == 0) return heights;

        int[] res = new int[heights.length - limit + 1];

        Deque<Integer> stack = new LinkedList<>();
        int r  = 0, l = 0;
        while (r < heights.length) {
            if (r >= limit) {
                res[l] = stack.peekFirst();
                if (stack.peekFirst() == heights[l]) { // 移除最左边的
                    stack.pollFirst();
                }
                l ++;
            }
            // 比之前的大，之前的去除
            while (!stack.isEmpty() && heights[stack.peekLast()] < heights[r]) {
                stack.pollLast();
            }
            stack.addLast(heights[r]); // 队列首部就是最大值
            r ++;
        }
        res[l] = stack.peekFirst(); // 最后一个
        return res;
    }
}
