package com.dflong.greenbull.leetcode;

public class _481 {
    public int magicalString(int n) {
        if (n < 4) return 1;

        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';

        int i = 2, j = 3;
        int res = 1;

        while (j < n) {
            int size = chars[i ++] - '0'; // 下一个元素数量
            int num = 3 - (chars[j - 1] - '0'); // 下一个元素
            while (size -- > 0 && j < n) {
                chars[j] = (char) (num + '0');
                if (chars[j] == '1') {
                    res ++;
                }
                j ++;
            }
        }

        return res;
    }
}
