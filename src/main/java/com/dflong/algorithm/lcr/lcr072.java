package com.dflong.algorithm.lcr;

public class lcr072 {

    public int mySqrt(int x) {
        int l = 0, r = x, res = - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == x) { // 不一定存在
                res = mid;
                return res;
            } else if ((long) mid * mid < x) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
