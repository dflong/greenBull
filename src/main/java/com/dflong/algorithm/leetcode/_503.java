package com.dflong.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _503 {

    public static void main(String[] args) {
        new _503().nextGreaterElements(new int[]{1, 2, 1});
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, - 1);
        for (int i = 0; i < nums.length * 2; i ++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek() % nums.length]) {
                res[stack.pop() % nums.length] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return res;
    }
}
