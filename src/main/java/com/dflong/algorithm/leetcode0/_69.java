package com.dflong.algorithm.leetcode0;

public class _69 {

    public static void main(String[] args) {
        _69 v = new _69();
        int i = v.mySqrt(80);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        if (x == 1) return x;
        if (x < 4) {
            return x / 2;
        }
        int y = x / 2;
        while (Math.pow(y, 2) > x) {
            y = y / 2;
        }
        y ++;
        while (Math.pow(y, 2) < x) {
            y ++;
        }
        if (Math.pow(y, 2) == x) {
            return y;
        }
        return y - 1;
    }
}
