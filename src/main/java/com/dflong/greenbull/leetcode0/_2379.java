package com.dflong.greenbull.leetcode0;

public class _2379 {

    public static void main(String[] args) {
        new _2379().minimumRecolors("WBBWWBBWBW", 7);
    }

    public int minimumRecolors(String blocks, int k) {
        // 统计蓝色B的数量
        int BCount = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                BCount ++;
            }
        }
        count = BCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                BCount ++;
            }
            if (blocks.charAt(i - k) == 'W') {
                BCount --;
            }
            count = Math.min(count, BCount);
        }
        return count;
    }
}
