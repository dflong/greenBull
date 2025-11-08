package com.dflong.greenbull.leetcode0;

import java.util.HashSet;

public class _202 {

    public static void main(String[] args) {
//        boolean happy = isHappy(7);
        System.out.println();
    }

    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) {
            return false;
        }
        set.add(n);

        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return isHappy(sum);
    }

    // 输入：n = 19
    //输出：true
    //解释：
    //12 + 92 = 82
    //82 + 22 = 68
    //62 + 82 = 100
    //12 + 02 + 02 = 1

}
