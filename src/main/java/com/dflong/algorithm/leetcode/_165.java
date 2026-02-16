package com.dflong.algorithm.leetcode;

public class _165 {

    public static void main(String[] args) {
        new _165().compareVersion("1.01", "1");
    }

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int x = 0;
            while (i < version1.length() &&  version1.charAt(i) != '.') {
                x = x * 10 + version1.charAt(i) - '0';
                i ++;
            }
            i ++; // 跳过 .

            int y = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                y = y * 10 + version2.charAt(j) - '0';
                j ++;
            }
            j ++; // 跳过 .

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }

        return 0;
    }
}
