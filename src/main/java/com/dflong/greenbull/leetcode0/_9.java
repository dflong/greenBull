package com.dflong.greenbull.leetcode0;

public class _9 {

    public boolean isPalindrome(int x) {
        String s = x + "";
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
