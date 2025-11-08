package com.dflong.greenbull.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class _658 {

    public static void main(String[] args) {
        new _658().findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分查找最接近x的
        List<Integer> res = new ArrayList<>();
        int r = binarySearch(arr, x), l = r - 1;

        while (k > 0 && l >= 0 && r < arr.length) {
            if (arr[l] == x) {
                l --;
            } else if (arr[r] == x) {
                r ++;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l --;
            } else {
                r ++;
            }
            k --;
        }

        while (k > 0 && l >= 0) {
            l--;
            k --;
        }

        while (k > 0 && r < arr.length) {
            r ++;
            k --;
        }

        for (int i = l + 1; i < r; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
