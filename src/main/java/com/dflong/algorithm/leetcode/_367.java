package com.dflong.algorithm.leetcode;

public class _367 {

    public boolean isPerfectSquare(int num) {
        // 二分查找
        int L = 1, R = num;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }
}
