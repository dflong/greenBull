package com.dflong.algorithm.leetcode;

import java.util.*;

public class _456 {

    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int k = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i --) {
            if (nums[i] < k) {
                return true;
            }

            // queue加入顺序是越来越小,弹出时则k越来越大 k < nums[i]
            while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                k = stack.pollLast();
            }
            stack.addLast(nums[i]);
        }
        return false;
    }
}
