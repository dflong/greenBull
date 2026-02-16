package com.dflong.algorithm.leetcode;

public class _371 {

    public static void main(String[] args) {
        new _371().getSum(1, 3);
    }

    public int getSum(int a, int b) {
        int res = 0, t = 0; // 进位
        for (int i = 0; i < 32; i ++) {
            int u1 = (a >> i) & 1, u2 = (b >> i) & 1;
            if (u1 == 1 && u2 == 1) {
                res = res | (t << i);
                t = 1;
            } else if (u1 == 1 || u2 == 1) {
                res = res | ((1 ^ t) << i);
                // 维持t
            } else {
                res = res | (t << i);
                t = 0;
            }
        }
        return res;
    }
}
