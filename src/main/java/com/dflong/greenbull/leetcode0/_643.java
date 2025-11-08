package com.dflong.greenbull.leetcode0;

public class _643 {

    public double findMaxAverage(int[] nums, int k) {
        double ave = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ave = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            ave = Math.max(ave, sum / k);
        }
        return ave;
    }
}
