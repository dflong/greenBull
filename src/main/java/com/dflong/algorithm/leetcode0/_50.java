package com.dflong.algorithm.leetcode0;

public class _50 {

    public double myPow(double x, int n) {
        return n >= 0 ? myPow2(x, n) : 1 / myPow2(x, -n);
    }

    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        double res = myPow2(x, n / 2);
        if(n % 2 == 0) {
            return res * res;
        }
        return res * res * x;
    }
}
