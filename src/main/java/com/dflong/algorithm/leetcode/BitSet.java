package com.dflong.algorithm.leetcode;

public class BitSet {

    public static void main(String[] args) {
        System.out.println("sssssss" +  (15 & 8));
        long[] longs = new long[15];
        java.util.BitSet set = java.util.BitSet.valueOf(longs);
        set.intersects(set); // 交集
    }
}
