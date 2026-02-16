package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _16 {

    public static void main(String[] args) {
        new _16().threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i ++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
                if (res == target) return target;
                if (temp < target) { // 比目标值小
                    l ++;
                } else {
                    r --;
                }
            }
        }
        return res;
    }
}
