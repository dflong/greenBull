package com.dflong.greenbull.leetcode;

public class _387 {

    public int firstUniqChar(String s) {
        int[] idx = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            idx[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i ++) {
            if (idx[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return - 1;
    }
}
