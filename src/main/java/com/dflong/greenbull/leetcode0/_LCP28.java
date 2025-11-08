package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _LCP28 {

    public int purchasePlans(int[] nums, int target) {
        int count = 0;
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = size - 1; i < j; i++) {
            while (i < j && nums[i] + nums[j] > target) {
                j --;
            }
            count = (count + j - i) % 1000000007;
        }
        return count % 1000000007;
    }
}
