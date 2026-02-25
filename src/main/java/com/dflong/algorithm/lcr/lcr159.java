package com.dflong.algorithm.lcr;

import java.util.Arrays;

public class lcr159 {

    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] vec = new int[cnt];
        Arrays.sort(stock);
        for (int i = 0; i < cnt; ++i) {
            vec[i] = stock[i];
        }
        return vec;
    }
}
