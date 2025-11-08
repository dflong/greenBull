package com.dflong.greenbull.leetcode0;

public class _1652 {

    public static void main(String[] args) {
        int[] decrypt = new _1652().decrypt(new int[]{2,4,9,3}, -2);
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }

        int[] codes = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            codes[i] = code[i % n];
        }

        int sum = 0;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        for (int i = l; i <= r; i++) {
            sum += codes[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum += codes[r + 1];
            sum -= codes[l];
            l ++; r ++;
        }
        return res;
    }
}
