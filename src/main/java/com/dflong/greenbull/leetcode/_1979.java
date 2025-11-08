package com.dflong.greenbull.leetcode;

public class _1979 {

    public static void main(String[] args) {
        new _1979().gcd(2, 5);
    }

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gcd = gcd(min, max);
        return gcd;
    }

    // a * b = 最大公约数 * 最小公倍数
    public int gcd(int a, int b) {
        int z = b;
        while (a % b != 0) {
            z = a % b;
            a = b;
            b = z;
        }
        return z;
    }
}
