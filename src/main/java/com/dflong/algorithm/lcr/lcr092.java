package com.dflong.algorithm.lcr;

public class lcr092 {

    public int minFlipsMonoIncr(String s) {
        int zero = 0, one = 0; // i位置分别是0, 1的最小翻转次数
        char[] charArray = s.toCharArray();
        zero = charArray[0] == '0' ? 0 : 1;
        one = charArray[0] == '1' ? 0 : 1;

        for (int i = 1; i < s.length(); i ++) {
            one = Math.min(one, zero); // 从上一次转换过来
            if (charArray[i] == '0') {
                one += 1; // 当前位置是0，则为1的需要+ 1
            } else {
                zero += 1;
            }
        }

        return Math.min(zero, one);
    }
}
