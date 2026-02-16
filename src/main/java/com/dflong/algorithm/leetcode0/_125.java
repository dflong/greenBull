package com.dflong.algorithm.leetcode0;

public class _125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }


    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int length = s.length();
        int l = 0, r = length - 1;
        while (l < r) {
            if (!((s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= '0' && s.charAt(l) <= '9'))) {
                l ++;
                continue;
            }
            if (!((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= '0' && s.charAt(r) <= '9'))) {
                r --;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
