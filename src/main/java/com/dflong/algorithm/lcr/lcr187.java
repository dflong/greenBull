package com.dflong.algorithm.lcr;

public class lcr187 {

    public int iceBreakingGame(int num, int target) {
        int f = 0;
        for (int i = 2; i != num + 1; ++i) {
            f = (target + f) % i;
        }
        return f;
    }
}
