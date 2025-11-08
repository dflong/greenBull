package com.dflong.greenbull.leetcode;

public class _483 {

    public String smallestGoodBase(String n) {
        // n = k^0 + k^1 + ... + k^m m越大k越小
        // m = log(n）/ log(2)
        // k = Math.pow(n, 1/m)

        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m >= 1; m --) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long nSUm = 1, mul = 1;
            for (int i = 1; i <= m; i ++) {
                mul *= k;
                nSUm += mul;
            }
            if (nSUm == nVal) {
                return k + "";
            }
        }

        return (nVal - 1) + "";
    }
}
