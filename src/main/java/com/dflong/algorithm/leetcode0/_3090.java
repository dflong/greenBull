package com.dflong.algorithm.leetcode0;

public class _3090 {

    public static void main(String[] args) {
        new _3090().maximumLengthSubstring("qsxboicldxhsjizgeoosurkcnfnn");
    }

    public int maximumLengthSubstring(String s) {
        int max = 0;
        int l = 0, r = 0, n = s.length();
        int[] nums = new int[26];
        while (r < n) {
            char c = s.charAt(r);
            nums[c - 'a'] ++;
            while (nums[c - 'a'] > 2) {
                max = Math.max(max, r - l);
                nums[s.charAt(l) - 'a'] --;
                l ++;
            }
            r ++;
        }
        return Math.max(max, r - l);
    }
}
