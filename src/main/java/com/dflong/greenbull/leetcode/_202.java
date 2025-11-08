package com.dflong.greenbull.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202 {

    public static void main(String[] args) {
        new _202().isHappy(2);
    }

    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        if (set.contains(n)) {
            return false;
        }
        set.add(n);

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return isHappy(sum);
    }
}
