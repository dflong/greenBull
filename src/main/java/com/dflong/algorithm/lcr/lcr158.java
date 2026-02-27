package com.dflong.algorithm.lcr;

public class lcr158 {

    public int inventoryManagement(int[] stock) {
        int cnt = 0, x = 0; // 找众数

        for (int i : stock) {
            if (cnt == 0) {
                x = i;
            }

            if (i == x) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        return x;
    }
}
