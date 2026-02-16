package com.dflong.algorithm.leetcode0;

public class _918 {

    // 一种是普通前缀和、一种是首尾前缀和
    public int maxSubarraySumCircular(int[] nums) {
        // 求普通前缀和
        int pre = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }

        // 求左前缀和最大值
        int[] leftDp = new int[nums.length];
        leftDp[0] = nums[0];
        int leftPre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftPre += nums[i];
            leftDp[i] = Math.max(leftDp[i - 1], leftPre);
        }

        // 左边最大前缀和 + 右边的数
        int rightNum = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            rightNum += nums[i];
            res = Math.max(res, rightNum + leftDp[i- 1]);
        }

        return res;
    }


}
