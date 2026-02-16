package com.dflong.algorithm.leetcode0;

public class _844 {

    public static void main(String[] args) {
        new _844().backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (s1.length() > 0) {
                    s1.deleteCharAt(s1.length() - 1);
                }
            } else {
                s1.append(c);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (s2.length() > 0) {
                    s2.deleteCharAt(s2.length() - 1);
                }
            } else {
                s2.append(c);
            }
        }

        return s1.toString().equals(s2.toString());
    }
}
