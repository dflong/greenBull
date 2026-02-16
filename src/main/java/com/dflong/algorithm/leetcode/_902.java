package com.dflong.algorithm.leetcode;

import java.util.*;

public class _902 {

    public static void main(String[] args) {
        new _902().atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100);
    }

    private char[] s;
    private int[] emeo;
    private int[] dd;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = Integer.toString(n).toCharArray();
        dd = new int[digits.length];
        for (int i = 0; i < digits.length; i++) dd[i] = Integer.parseInt(digits[i]);
        int m = s.length;
        emeo = new int[m];
        Arrays.fill(emeo, -1);
        return f(0, true, false);
    }

    // isNum 是否选择了当前位， 为了去除前导0
    // https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/solutions/1900038/by-lfool-epqy/?envType=problem-list-v2&envId=bec5g5r
    private int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) return isNum ? 1 : 0;
        if (!isLimit && isNum && emeo[i] != -1) return emeo[i];
        int up = isLimit ? s[i] - '0' : 9;
        int res = isNum ? 0 : f(i + 1, false, false);
        for (int d : dd) {
            if (d <= up) {
                res += f(i + 1, isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) emeo[i] = res;
        return res;
    }

}
