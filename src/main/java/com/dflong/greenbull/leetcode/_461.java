package com.dflong.greenbull.leetcode;

public class _461 {

    public static void main(String[] args) {
        new _461().hammingDistance(1, 4);
    }

    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 32; i ++) {
            int a = (x >> i) & 1, b = (y >> i) & 1;
            cnt += a ^ b;
        }
        return cnt;
    }
}
