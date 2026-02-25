package com.dflong.algorithm.lcr;

public class lcr134 {

    public double myPow(double x, int n) {
        // 递归
        return n >= 0 ? subPow(x, n) : 1 / subPow(x, n);
    }

    double subPow(double x, int n) {
        if (n == 0) return 1;

        double pow = subPow(x, n / 2);

        if (n % 2 == 0) return pow * pow;
        else return pow * pow * x;
    }
}
