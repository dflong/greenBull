package com.dflong.algorithm.lcr;

public class lcr073 {

    public int minEatingSpeed(int[] piles, int h) {
        // 二分查找
        int l = 1, r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int res = r;
        while (l < r) {
            int speed = (r + l) / 2;
            long time = getTime(speed, piles);
            if (time <= h) {
                res = speed;
                r = speed;
            } else {
                l = speed + 1;
            }
        }
        return res;
    }

    private long getTime(int speed, int[] piles) {
        long time = 0;
        for (int p : piles) {
            time += (p - 1 + speed) / speed;
        }
        return time;
    }
}
