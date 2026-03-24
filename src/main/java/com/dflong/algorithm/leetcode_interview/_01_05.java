package com.dflong.algorithm.leetcode_interview;

public class _01_05 {

    public boolean oneEditAway(String first, String second) {
        if (first.length() > second.length()) return oneEditAway(second, first);

        int m = first.length(), n = second.length();
        if (n - m > 1) return false;

        if (first.length() == second.length()) {
            int cnt = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt ++;
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return true;
        }

        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) { // 已经有一次不相等了，判断后续
                i ++;
            }
            j ++;
            if (j - i > 1) {
                return false;
            }
        }
        return true;
    }
}
