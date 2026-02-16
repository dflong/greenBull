package com.dflong.algorithm.leetcode0;

public class _860 {

    public boolean lemonadeChange(int[] bills) {
        int profit5 = 0;
        int profit10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                profit5 += 5;
            } else if (bill == 10) {
                profit10 += 10;
                if (profit5 >= 5) {
                    profit5 -= 5;
                } else {
                    return false;
                }
            } else {
                if (profit10 >= 10) {
                    profit10 -= 10;
                    if (profit5 >= 5) {
                        profit5 -= 5;
                    } else {
                        return false;
                    }
                } else if (profit5 >= 15) {
                    profit5 -= 15;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
