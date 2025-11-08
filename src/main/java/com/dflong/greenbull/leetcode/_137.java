package com.dflong.greenbull.leetcode;

public class _137 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j ++) {
                sum += ((nums[j] >> i) & 1);
            }

            if (sum % 3 != 0) {
                res = res | (1 << i);
            }
        }

        return res;
    }
}
