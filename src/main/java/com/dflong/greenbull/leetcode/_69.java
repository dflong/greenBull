package com.dflong.greenbull.leetcode;

public class _69 {

    public int mySqrt(int x) {
        int L = 0, R = x, ans = 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
}
