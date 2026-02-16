package com.dflong.algorithm.lcr;

public class lcr075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数排序
        int high = 0;
        for (int i : arr1) {
            high = Math.max(high, i);
        }
        int[] sorted = new int[high + 1];
        for (int i : arr1) {
            sorted[i] ++; // 计数
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < sorted[i]; j ++) {
                res[idx++] = i;
            }
            sorted[i] = 0;
        }

        for (int i = 0; i <= high; i ++) {
            for (int j = 0; j < sorted[i]; j ++) {
                res[idx++] = i;
            }
            sorted[i] = 0;
        }
        return res;
    }
}
