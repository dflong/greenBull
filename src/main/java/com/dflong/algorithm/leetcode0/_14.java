package com.dflong.algorithm.leetcode0;

public class _14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }

    // "flower","flow","flight"
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return null;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String res = s1(strs[0], strs[1]);;

        for (int i = 1; i < strs.length - 1; i++) {
            String s = s1(strs[i], strs[i + 1]);
            if (s == "") {
                return "";
            }
            if (res.length() > s.length()) {
                res = s;
            }

        }

        return res;
    }

    public static String s1 (String s1, String s2) {

        String res = "";

        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0, j = 0;
        while(i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                res += s1.charAt(i);
                i ++;
                j ++;
            } else {
                break;
            }
        }
        return res;
    }
}
