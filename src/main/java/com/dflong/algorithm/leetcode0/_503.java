package com.dflong.algorithm.leetcode0;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _503 {

    public static void main(String[] args) {
        new _503().nextGreaterElements(new int[]{1,2,3,4,3});
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, - 1);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek() % n] < num) {
                Integer pop = stack.pop();
                res[pop % n] = num;
            }
            stack.push(i);
        }
        return res;
    }
}
