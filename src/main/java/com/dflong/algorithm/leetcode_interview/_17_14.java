package com.dflong.algorithm.leetcode_interview;

public class _17_14 {

    public int[] smallestK(int[] arr, int k) {
        this.arr = arr;
        this.k = k;

        sort(0, arr.length - 1);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    int[] arr;
    int k;

    void sort(int l, int r) {
        if (l >= r) return;

        int idx = partition(l, r);

        if (idx == k) return;
        else if (idx < k) {
            sort(idx + 1, r);
        } else {
            sort(l, idx - 1);
        }
    }

    int partition(int l, int r) {
        int idx = l; // 哨兵点
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[idx]) {
                j --;
            }
            while (i < j && arr[i] <= arr[idx]) {
                i ++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;

        return i;
    }
}
