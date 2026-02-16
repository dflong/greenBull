package com.dflong.algorithm.leetcode;

public class _541 {

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, s.length() - 1);
            while (l < r) {
                char temp = charArray[l];
                charArray[l++] = charArray[r];
                charArray[r--] = temp;
            }
        }
        return new String(charArray);
    }
}
