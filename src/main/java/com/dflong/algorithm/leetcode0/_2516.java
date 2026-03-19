package com.dflong.algorithm.leetcode0;

public class _2516 {

    // ccbabccccbabcc
    public int takeCharacters(String s, int k) {
        int[] counts = new int[3]; // 反向思维：滑动窗口保证窗口外数量满足条件
        for (char c : s.toCharArray()) {
            counts[c - 'a'] ++;
        }

        if (counts[0] < k || counts[1] < k || counts[2] < k) {
            return - 1;
        }

        int max = 0;
        int l = 0, r = 0;
        for (; r < s.length(); r ++) {
            // 移入滑动窗口
            int idx = s.charAt(r) - 'a';
            counts[idx] --;

            while (counts[idx] < k) {
                // 移出滑动窗口
                counts[s.charAt(l) - 'a'] ++;
                l ++;
            }

            max = Math.max(max, r - l + 1); // 得到滑动窗口的最大值
        }

        return s.length() - max;
    }
}
