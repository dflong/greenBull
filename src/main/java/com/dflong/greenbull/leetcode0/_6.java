package com.dflong.greenbull.leetcode0;

import java.util.Arrays;

public class _6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        if (n <= numRows) return s;

        String[] row = new String[numRows];
        Arrays.fill(row, "");

        int idx = 0; // 在第几行
        boolean flag = true; // 向上、下
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (idx == 0) { // 首行
                row[idx ++] += c;
                flag = true;
            } else if (idx == numRows - 1) { // 尾行
                row[idx --] += c;
                flag = false;
            } else { // 中间行
                row[idx] += c;
                if (flag) {
                    idx ++;
                } else {
                    idx --;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (String s1 : row) {
            res.append(s1);
        }
        return res.toString();
    }
}
