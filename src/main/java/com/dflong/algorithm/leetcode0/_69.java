package com.dflong.algorithm.leetcode0;

public class _69 {

    public static void main(String[] args) {
        _69 v = new _69();
        int i = v.mySqrt(80);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 牛顿迭代法
        s = x;
        return (int) sqrt(x);
    }
    int s;

    double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }
}
