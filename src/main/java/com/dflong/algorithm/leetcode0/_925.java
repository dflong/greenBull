package com.dflong.algorithm.leetcode0;

public class _925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        if (name.length() > typed.length()) return false;

        while (i < m && j < n) {
            char nameC = name.charAt(i);
            char typedC = typed.charAt(j);
            if (nameC == typedC) {
                i++; j++;
            } else {
                if (i > 0 && name.charAt(i - 1) == typedC) {
                    j ++;
                } else {
                    return false;
                }
            }
        }

        while (j < n) {
            char nameC = name.charAt(m - 1);
            char typedC = typed.charAt(j);
            if (nameC == typedC) {
                j++;
            } else {
                return false;
            }
        }
        return i == m;
    }
}
