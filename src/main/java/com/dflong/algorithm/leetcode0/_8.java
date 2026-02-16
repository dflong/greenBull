package com.dflong.algorithm.leetcode0;

public class _8 {

    public static void main(String[] args) {
        new _8().myAtoi("4193 with words");
    }

    int negative = 0; // 负号的数量
    boolean hasNum = false; // 已经有整数
    boolean hasPlus = false; // 已经有加号
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                if (hasPlus) break;
                if (negative > 0) break;
                if (hasNum) break;
                negative ++;
            } else if (c == '+'){
                if (hasNum) break;
                if (negative > 0) break;
                if (hasPlus) break;
                hasPlus = true;
            }
            else if (c >= '0' && c <= '9') {
                sb.append(c);
                hasNum = true;
            } else if (c == ' ') {
                if (hasPlus) break;
                if (hasNum) break;
            } else {
                break;
            }
        }

        long num = 0;
        for (int i = 0; i < sb.length(); i++) {
            num = Math.abs(num) * 10 + (sb.charAt(i) - '0');
            if (negative % 2 == 1) num = - num;
            if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) num;
    }
}
