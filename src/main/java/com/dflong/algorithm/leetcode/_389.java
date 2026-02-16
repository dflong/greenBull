package com.dflong.algorithm.leetcode;

public class _389 {

    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            cs[t.charAt(i) - 'a'] ++;
            cs[s.charAt(i) - 'a'] --;
        }
        cs[t.charAt(t.length() - 1) - 'a'] ++;

        for (int i = 0; i < cs.length; i ++) {
            if (cs[i] > 0) return (char) (i + 'a');
        }

        return (char) 0;
    }
}
