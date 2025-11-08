package com.dflong.greenbull.leetcode;

public class _434 {

    public int countSegments(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        int cnt = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == ' ' && prev != ' ') {
                cnt ++;
            }
            prev = s.charAt(i);
        }
        if (!s.endsWith(" ")) {
            cnt ++;
        }
        return cnt;
    }
}
