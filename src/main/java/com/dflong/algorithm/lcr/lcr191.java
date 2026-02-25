package com.dflong.algorithm.lcr;

public class lcr191 {

    public int[] statisticalResult(int[] arrayA) {
        if (arrayA == null || arrayA.length == 0) return arrayA;
        // 维护左侧、右侧的乘积
        int[] left = new int[arrayA.length];
        int[] right = new int[arrayA.length];

        left[0] = right[arrayA.length - 1] = 1; // 初始化

        for (int i = 1; i < arrayA.length; i ++) {
            left[i] = left[i - 1] * arrayA[i - 1];
        }

        for (int i = arrayA.length - 2; i >= 0; i --) {
            right[i] = right[i + 1] * arrayA[i + 1];
        }

        int[] res = new int[arrayA.length];
        for (int i = 0; i < arrayA.length; i ++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
