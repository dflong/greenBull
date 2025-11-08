package com.dflong.greenbull.leetcode0;

public class _137 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int te = 0;
            for (int num : nums) {
                te += (num >> i) & 1;
            }
            if (te % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }

}
