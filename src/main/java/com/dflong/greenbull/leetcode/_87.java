package com.dflong.greenbull.leetcode;

public class _87 {

    public static void main(String[] args) {
        new _87().isScramble("rgeat", "great");
    }

    int[][][][] res;
    char[] s1, s2;
    public boolean isScramble(String s1, String s2) {
        int n = s1.length() ;
        res = new int[n][n][n][n];
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        return isScramble(0, n - 1, 0, n - 1);
    }

    public boolean isScramble(int start1, int end1, int start2, int end2) {
        if (start1 == end1) return s1[start1] == s2[start2]; //只有一个元素

        if (res[start1][end1][start2][end2] != 0) return res[start1][end1][start2][end2] > 0;

        for (int i = 0; i < end1 - start1; i ++) {
            if ((isScramble(start1, start1 + i, start2, start2 + i) &&
                    isScramble(start1 + i + 1, end1,start2 + i + 1, end2))
                    ||
                    (isScramble(start1, start1 + i, end2 - i, end2) &&
                    isScramble(start1 + i + 1, end1, start2, end2 - i - 1)))
            {
                res[start1][end1][start2][end2] = 1;
                return true;
            }
        }

        res[start1][end1][start2][end2] = - 1;
        return false;
    }


}
