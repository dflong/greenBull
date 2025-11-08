package com.dflong.greenbull.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _89 {

    public static void main(String[] args) {
        new _89().grayCode(3);
    }

    public List<Integer> grayCode(int n) {
        int max = (int) Math.pow(2, n) - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= max; i ++) {
            list.add(i ^ i >> 1);
        }
        return list;
        // 0000 0001  0010  0011  0100 0101  0110
    }
}
