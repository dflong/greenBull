package com.dflong.algorithm.lcr;

public class lcr126 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1;
        int c = 1;
        for (int i = 2; i <= n; i ++) {
            c = (a + b) & 1000000008;
            a = b;
            b = c;
        }

        return c;
    }
}
