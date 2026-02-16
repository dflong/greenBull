package com.dflong.algorithm.leetcode0;

import java.util.Deque;
import java.util.LinkedList;

public class _42 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }

    // 0,1,0,2,1,0,1,3,2,1,2,1
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }

        return res;
    }

    // 单调栈实现
    public static int trap1(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (stack.size() > 1 && height[i] > height[stack.peek()]) {
                 int cur = stack.pop();
                 int left = stack.peek();
                 int temp = (Math.min(height[left], height[i]) - height[cur]) * (i - left - 1);
                 if (temp > 0) {
                     sum += temp;
                 }
            }
            stack.push(i);
        }
        return sum;
    }
}
