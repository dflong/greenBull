package com.dflong.algorithm.lcr;

public class lcr034 {

    public boolean isAlienSorted(String[] words, String order) {
        // order 是26字母排序
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i ++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i ++) {
            boolean valid = false;
            for (int j = 0; j < words[i].length() && j < words[i - 1].length(); j ++) {
                int prev = orders[words[i - 1].charAt(j) - 'a'];
                int curr = orders[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                /* 比较两个字符串的长度 */
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
