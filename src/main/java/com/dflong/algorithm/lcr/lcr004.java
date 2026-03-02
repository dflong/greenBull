package com.dflong.algorithm.lcr;

public class lcr004 {

    public int singleNumber(int[] nums) {
        int[] bits = new int[32]; // 从低到高

        for (int num : nums) {
            int mark = 1;
            for (int i = 0; i < 32; i ++) {
                if ((num & mark) != 0) {
                    bits[i] ++;
                }
                mark <<= 1; // 增大
            }
        }

        int res = 0;
        for (int i = 31; i >= 0; i --) {
            res <<= 1;
            res += bits[i] % 3;
        }

        return res;
    }
}
