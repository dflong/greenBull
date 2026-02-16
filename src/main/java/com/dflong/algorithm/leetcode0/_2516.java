package com.dflong.algorithm.leetcode0;

public class _2516 {

    // ccbabccccbabcc
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] counts = new int[3];
        int l = 0, n = s.length(), min = n + 1;
        for (int r = 0; r < n * 2; r ++) {
            counts[s.charAt(r % n) - 'a']++;
            while (counts[0] >= k && counts[1] >= k && counts[2] >= k &&
                    ((l <= n - 1 && n - 1 <= r) || (l <= n && n <= r))) {
                min = Math.min(min, r - l + 1);
                counts[s.charAt(l % n) - 'a']--;
                l ++;
            }
        }
        return min > s.length() ? -1 : min;
    }
}
