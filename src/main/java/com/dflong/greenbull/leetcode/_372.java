package com.dflong.greenbull.leetcode;

public class _372 {

    public static void main(String[] args) {
        new _372().superPow(2, new int[]{1, 0});
    }

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int res = 1;
        for (int i = b.length - 1; i >= 0; i --) {
            // a的次方分成了两次
            res = (int) ((long)res * pow(a, b[i]) % MOD);
            a = pow(a, 10); // a ^ (x + y) = a ^ 10x * a ^ y
        }
        return res;
    }

    public int pow(int x, int n) {
       if (n == 0) return 1;
       int res = pow(x, n / 2) % MOD;

       return n % 2 == 0 ? (int)((long)(res * res) % MOD) : (int)(((long) res * res * x) % MOD);
    }
}

