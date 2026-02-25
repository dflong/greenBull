package com.dflong.algorithm.lcr;

public class lcr127 {

    public int trainWays(int num) {
        int a = 1, b = 2;
        if (num == 0) return 1;
        if (num == 1) return a;
        if (num == 2) return b;
        for (int i = 3; i <= num; i ++) {
            int temp =  (a * b) % 1000000007;
            a = b;
            b = temp;
        }
        return b;
    }
}
