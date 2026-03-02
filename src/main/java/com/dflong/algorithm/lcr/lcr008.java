package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr008 {

    public static void main(String[] args) {
        new lcr008().minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int l = 0, r = 0, sum = 0;
        while (r < nums.length) {
            sum += nums[r ++];
            while (sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l ++];
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
