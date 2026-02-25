package com.dflong.algorithm.lcr;

public class lcr190 {

    public int encryptionCalculate(int a, int b) {
        if (b == 0) return a;

        int temp = a ^ b;
        b = (a & b) << 1; // 是否有进位
        return encryptionCalculate(temp,  b);
    }
}
