package com.dflong.algorithm.leetcode;

import java.util.Arrays;

public class _423 {

    public static void main(String[] args) {
        new _423().originalDigits("owoztneoer");
    }

    public String originalDigits(String s) {
        // 根据每个单词使用了字母唯一性确定了遍历顺序
        String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            cnt[s.charAt(i) - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            // 根据优先级看这个单词最多有几个
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) {
                k = Math.min(k, cnt[c - 'a']);
            }
            // 删除使用过的字母
            for (char c : ss[i].toCharArray()) {
                cnt[c - 'a'] -= k;
            }
            while (k -- > 0) {
                sb.append(i);
            }
        }

        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
