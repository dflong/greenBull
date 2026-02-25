package com.dflong.algorithm.lcr;

public class lcr133 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1; // n & (n - 1)等于把n的最低位1变成0，所以最后n=0代表没有1了
            res ++;
        }
        return res;
    }
}
