package com.dflong.algorithm.leetcode;

public class _476 {

    public int findComplement(int num) {
        // 找最高位1
        int s = 0;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < s; i ++) {
            if (((num >> i) & 1) == 0) {
                res |= 1 << i;
            }
        }

        return res;
    }
}
