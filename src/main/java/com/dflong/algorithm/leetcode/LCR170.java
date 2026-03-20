package com.dflong.algorithm.leetcode;

import java.util.*;

public class LCR170 {

    public static void main(String[] args) {
        new LCR170().reversePairs(new int[] {7,6,5,4});
    }

    public int reversePairs(int[] record) {
        // 先离散
        Set<Integer> set = new HashSet<>();
        for (int num : record) {
            set.add(num);
        }
        int[] dec = new int [set.size()];
        int i = 0;
        for (int num : set) {
            dec[i ++] = num;
        }
        Arrays.sort(dec); // 从小到大排序
        // 初始化树状数组
        lows = new int[dec.length + 1];
        int res = 0;
        for (i = record.length - 1; i >= 0; i --) {
            // record[i] 在 dec 中的索引
            int idx = Arrays.binarySearch(dec, record[i]) + 1; // 索引值 + 1
            res += query(idx - 1); // 找比大小的
            update(idx); // 更新
        }
        return res;
    }

    int[] lows; // 记录数量
    public void update(int idx) {
        while (idx < lows.length) {
            lows[idx] += 1;
            idx += lowBit(idx);
        }
    }

    public int lowBit(int x) {
        return x & (- x);
    }

    public int query(int idx) {
        int res = 0;
        while (idx > 0) {
            res += lows[idx];
            idx -= lowBit(idx);
        }

        return res;
    }
}

