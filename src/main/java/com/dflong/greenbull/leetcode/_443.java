package com.dflong.greenbull.leetcode;

public class _443 {

    public static void main(String[] args) {
        new _443().compress(new char[] {'a', 'b', 'c'});
    }

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        StringBuilder sb = new StringBuilder();
        int prevIdx = 0, len = 0;
        for (int i = 1; i < chars.length; i ++) {
            char prev = chars[prevIdx];
            while (i < chars.length && chars[i] == prev) {
                i ++;
            }

            sb.append(chars[prevIdx]);
            len = i - prevIdx;
            if (len > 1) {
                String numStr = String.valueOf(len);
                for (char c : numStr.toCharArray()) {
                    sb.append(c);
                }
            }
            prevIdx = i;
        }
        if (prevIdx == chars.length - 1) {
            sb.append(chars[chars.length - 1]);
        }

        for (int i = 0; i < sb.length(); i ++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
