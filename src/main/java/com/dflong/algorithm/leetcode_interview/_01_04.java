package com.dflong.algorithm.leetcode_interview;

public class _01_04 {

    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] ++;
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                cnt ++;
            }
            if (cnt > 1) return false;
        }
        return true;
    }
}
