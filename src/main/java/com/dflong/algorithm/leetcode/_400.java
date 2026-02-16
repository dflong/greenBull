package com.dflong.algorithm.leetcode;

public class _400 {

    public int findNthDigit(int n) {
        // 在哪个数字段
        long start = 1, digit = 1, cnt = 9;
        while (n > cnt) {
            n -= cnt;
            start *= 10;
            digit ++;
            cnt = start * digit * 9;
        }

        // 哪个数字
        long num = start + (n - 1) / digit;

        // 哪位
        String s = String.valueOf(num);
        return s.charAt((int) ((n - 1) % digit)) - '0';
    }
}
