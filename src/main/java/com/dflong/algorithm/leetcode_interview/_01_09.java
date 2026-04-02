package com.dflong.algorithm.leetcode_interview;

public class _01_09 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.contains(s2); // _28的字符串匹配
    }
}
