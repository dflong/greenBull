package com.dflong.greenbull.leetcode;

public class _318 {

    public int maxProduct(String[] words) {
        // 保存每一位
        int[] mask = new int[words.length];
        int idx = 0;
        for (String w : words) {
            int t = 0;
            for (int i = 0; i < w.length(); i++) {
                int j = w.charAt(i) - 'a';
                t |= (1 << j);
            }

            mask[idx++] = t;
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((mask[j] & mask[i])== 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
