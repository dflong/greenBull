package com.dflong.greenbull.leetcode;

public class _470 {

    public int rand10() {
        int r1 = rand7();
        int r2 = rand7();
        int res = r1 + (r2 - 1) * 7;
        while (res > 40) {
            r1 = rand7();
            r2 = rand7();
            res = r1 + (r2 - 1) * 7;
        }
        return (res - 1) % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}
