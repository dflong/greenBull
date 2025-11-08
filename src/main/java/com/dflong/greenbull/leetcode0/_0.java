package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0 {



    // 判断字串是否回文
    boolean[][] f;
    int n;
    List<String> res = new ArrayList<>();

    public void isFor(String s) {
        this.n = s.length();
        f = new boolean[n][n];

        for (int i = 0; i < n; i ++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n -1; i >= 0; i --) {
            for (int j = i + 1; j < n; j ++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = i; j < n; j ++) {
                if (f[i][j]) {
                    res.add(s.substring(i, j + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        _0 v = new _0();
        int search = v.search(new int[]{2, 3, 4, 7, 9, 0, 1}, 0);
        System.out.println(search);
    }

    // 二分查找
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length - 1);
    }

    public int binarySearch(int l, int r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (l >= r) {
            return -1;
        }

        int i = binarySearch(l, mid - 1);
        if (i != -1) {
            return i;
        }

        return binarySearch(mid + 1, r);
    }
}
