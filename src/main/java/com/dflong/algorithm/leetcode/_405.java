package com.dflong.algorithm.leetcode;

public class _405 {

    public String toHex(int num) {
        if (num == 0) return "0";
        String s = "0123456789abcdef";
        StringBuffer sb = new StringBuffer();

        while (num != 0) {
            sb.insert(0, s.charAt(num & 0xf));
            num >>>= 4;
        }

        return sb.toString();
    }
}
