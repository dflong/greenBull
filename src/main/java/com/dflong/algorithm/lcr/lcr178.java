package com.dflong.algorithm.lcr;

public class lcr178 {

    public int trainingPlan(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] bits = new int[32]; // 32位按位加和

        for (int num : nums) {
            int bitMask = 1;
            for (int i = 0; i < 32; i ++) {
                if ((num & bitMask) != 0) bits[i] ++;
                bitMask <<= 1;
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
