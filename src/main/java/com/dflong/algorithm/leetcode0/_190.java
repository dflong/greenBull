package com.dflong.algorithm.leetcode0;

public class _190 {

    public static void main(String[] args) {
        _190 v = new _190();
        int i = v.reverseBits(1);
        System.out.println(i);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}
