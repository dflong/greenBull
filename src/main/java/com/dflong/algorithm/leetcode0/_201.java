package com.dflong.algorithm.leetcode0;

public class _201 {

    public static void main(String[] args) {
        _201 v = new _201();
        int i = v.rangeBitwiseAnd(5, 6);
        System.out.println(i);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        while (left != right) {
            left >>>= 1;
            right >>>= 1;
            res ++;
        }
        return left << res;
    }
}
