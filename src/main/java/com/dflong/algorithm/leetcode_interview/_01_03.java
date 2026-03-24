package com.dflong.algorithm.leetcode_interview;

public class _01_03 {

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();


        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(S.charAt(i));
            }
            cnt ++;
            if (cnt == length) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
