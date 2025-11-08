package com.dflong.greenbull.leetcode0;

public class _2105 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int va = capacityA;
        int vb = capacityB;

        int l = 0, r = n - 1, min = 0;
        while (l < r) {
            if (plants[l] <= va) {
                va -= plants[l];
            } else {
                va = capacityA - plants[l];
                min ++;
            }

            if (plants[r] <= vb) {
                vb -= plants[r];
            } else {
                vb = capacityB - plants[r];
                min ++;
            }

            l ++;
            r --;
        }

        if (l == r && Math.max(va, vb) < plants[l]) {
            min ++;
        }

        return min;
    }
}
