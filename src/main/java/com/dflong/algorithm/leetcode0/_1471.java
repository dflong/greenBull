package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _1471 {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);

        int[] res = new int[k];
        int n = arr.length, m = (n - 1) / 2;

        int l = 0, r = n - 1;
        while (k > 0) {
            if (Math.abs(arr[l] - arr[m]) > Math.abs(arr[r] - arr[m])) {
                res[k - 1] = arr[l];
                l ++;
            } else if (Math.abs(arr[l] - arr[m]) == Math.abs(arr[r] - arr[m]) && arr[l] > arr[r]) {
                res[k - 1] = arr[l];
                l ++;
            } else {
                res[k - 1] = arr[r];
                r --;
            }
            k --;
        }
        return res;
    }
}
