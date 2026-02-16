package com.dflong.algorithm.leetcode;

public class _171 {

    public static void main(String[] args) {
        new _171().titleToNumber("AB");
    }

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i ++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
