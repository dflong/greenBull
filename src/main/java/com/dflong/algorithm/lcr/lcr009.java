package com.dflong.algorithm.lcr;

public class lcr009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0;
        int l = 0, r = 0, sum = 1;
        while (r < nums.length) {
            sum *= nums[r ++];
            while (sum >= k) {
                sum /= nums[l ++];
            }
            res += l - r;
        }
        return res;
    }
}
