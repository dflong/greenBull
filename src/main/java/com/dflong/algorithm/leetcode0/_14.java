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

        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < res.length() && j < strs[i].length()) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j ++;
            }
            res = res.substring(0, j);
        }

        return res;
    }

}
