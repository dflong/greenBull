package com.dflong.algorithm.leetcode_interview;

public class _01_01 {

    public boolean isUnique(String astr) {
        int[] arr = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int idx = astr.charAt(i) - 'a';
            if (arr[idx] == 1) {
                return false;
            }
            arr[idx] = 1;
        }
        return true;
    }
}
