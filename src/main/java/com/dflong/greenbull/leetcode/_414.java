package com.dflong.greenbull.leetcode;

public class _414 {

    public static void main(String[] args) {
        new _414().thirdMax(new int[]{2, 2, 3, 1});
    }

    public int thirdMax(int[] nums) {
        long big1 = Long.MIN_VALUE, big2 = Long.MIN_VALUE, big3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > big1) {
                big3 = big2;
                big2 = big1;
                big1 = num;
            } else if (num > big2) {
                if (num == big1) continue;
                big3 = big2;
                big2 = num;
            } else if (num > big3) {
                if (num == big2) continue;
                big3 = num;
            }
        }

        return (int) (big3 == Long.MIN_VALUE ? big1 : big3);
    }
}
