package com.dflong.algorithm.leetcode;

public class _479 {

    public static void main(String[] args) {
        int i = new _479().largestPalindrome(2);
    }

    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        // n位置结果2*n
        int max = (int) (Math.pow(10, n) - 1);
        for (int left = max; left > 0; left --) {
            long p = left;
            for (int right = left; right > 0; right /= 10) {
                p = p * 10 + right % 10; // 得到完整数字
            }

            for (long i = max; i * i >= p; i --) { // 从最大值开始除
                if (p % i == 0) { // 能除尽
                    return (int) (p % 1337);
                }
            }
        }
        return 0;
    }
}
