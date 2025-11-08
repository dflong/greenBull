package com.dflong.greenbull.leetcode;

public class _223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sa = (ax2 - ax1) * (ay2 - ay1), sb = (bx2 - bx1) * (by2 - by1);

        int overWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overS = Math.max(overWidth, 0) * Math.max(overHeight, 0);
        return sa + sb - overS;
    }
}
