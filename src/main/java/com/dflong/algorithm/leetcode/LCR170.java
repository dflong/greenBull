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

//    private void update(int idx) {
//        while (idx < c.length) {
//            c[idx] += 1;
//            idx += lowBit(idx);
//        }
//    }

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

//    public int reversePairs(int[] record) {
//        List<Integer> integers = countSmaller(record);
//        int sum = 0;
//        for (Integer i : integers) {
//            sum += i;
//        }
//
//        return sum;
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//
//        des(nums); // 离散
//        init(a.length + 1); // 初始化
//
//        for (int i = nums.length - 1; i >= 0; i --) {
//            int id = getId(nums[i]);
//            res.add(query(id - 1));
//            update(id);
//        }
//        Collections.reverse(res);
//        return res;
//    }
//
//    private void update(int idx) {
//        while (idx < c.length) {
//            c[idx] += 1;
//            idx += lowBit(idx);
//        }
//    }
//
//    private int query(int idx) {
//        int res = 0;
//        while (idx > 0) {
//            res += c[idx];
//            idx -= lowBit(idx);
//        }
//        return res;
//    }
//
//    private int lowBit(int x) {
//        return x & (- x);
//    }
//
//    private int getId(int x) {
//        return Arrays.binarySearch(a, x) + 1;
//    }
//
//    private void init(int size) {
//        c = new int[size];
//    }
//
//    int[] a; // 离散后的数组
//    int[] c; // 前缀和
//
//    private void des(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i : nums) {
//            set.add(i);
//        }
//        a = new int[set.size()];
//        int idx = 0;
//        for (Integer i : set) {
//            a[idx ++] = i;
//        }
//        Arrays.sort(a);
//    }
}

