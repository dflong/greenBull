package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _2090 {

    public static void main(String[] args) {
        new _2090().getAverages(new int[] {
            2, 1
        }, 1);
    }

    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length < 2 * k + 1) {
            return res;
        }

        long sum = 0L;
        int n = 2 * k + 1;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        res[k ++] = (int) (sum / n);

        for (int i = n; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - n];
            res[k ++] = (int) (sum / n);
        }
        return res;
    }
}
