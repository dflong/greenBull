package com.dflong.greenbull.leetcode;

public class _860 {

    public boolean lemonadeChange(int[] bills) {
        int bill5 = 0, bill10 = 0, bill20 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                bill5 += 5;
            }
            else if (bill == 10) {
                bill10 += 10;
                // 找零5元
                if (bill5 < 5) return false;
                bill5 -= 5;
            }
            else if (bill == 20) {
                bill20 += 20;
                // 找零15元
                if (bill10 >= 10) {
                    bill10 -= 10;
                    if (bill5 < 5) return false;
                    bill5 -= 5;
                } else {
                    if (bill5 < 15) return false;
                    bill5 -= 15;
                }
            }
        }
        return true;
    }
}
