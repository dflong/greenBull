package com.dflong.algorithm.leetcode;

public class _45 {

    public int jump(int[] nums) {
        int cur = 0, next = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) { // 这一步能到达的最远距离
                cur = next; // 更新最远距离
                res ++; // 步数 + 1
            }
        }
        return res;
    }
}
