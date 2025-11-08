package com.dflong.greenbull.leetcode;

public class _393 {

    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n;) {
            int len = getLen(data[i]);
            if (len < 0 || i + len > n) return false;

            for (int j = 1; j < len; j ++) {
                if (!valid(data[i + j])) return false;
            }
            i = i + len;
        }
        return true;
    }

    public boolean valid(int data) {
        return (data & MASK2) == MASK;
    }

    private int getLen(int data) {
        if ((data & MASK) == 0) return 1;
        int mask = MASK;
        int n = 0; // n不能为1
        while ((data & mask) != 0) {
            n ++;
            if (n > 4) return - 1;
            mask = mask >> 1;
        }
        return n >= 2 ? n : - 1;
    }

    int MASK2 = (1 << 7) + (1 << 6);
    int MASK = 1 << 7;
}
