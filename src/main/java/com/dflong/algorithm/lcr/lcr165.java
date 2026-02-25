package com.dflong.algorithm.lcr;

public class lcr165 {

    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) { // 爬楼梯
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : b;
            a = b;
            b = c;
        }
        return b;
    }
}
