package com.dflong.greenbull.leetcode;

public class _42 {

    public int trap(int[] height) {
        // 当前位置的最高高度
        int[] leftDp = new int[height.length];

        // leftDp[i] = max(leftDp[i - 1], height[i])

        leftDp[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i]);
        }

        int[] rightDp = new int[height.length];

        rightDp[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftDp[i], rightDp[i]) - height[i];
        }

        return sum;
    }
}
