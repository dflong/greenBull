package com.dflong.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{4, 2, 1, 0, 3, 3, 5});
    }

    // 4, 2, 1, 0, 3, 5
    //            i j
    // 3, 2, 1, 0, 4, 5
    // 0, 2, 1, 3, 4, 5
    // 0, 2, 1, 3, 4, 5
    // 0, 1, 2, 3, 4, 5
    void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int idx = l; // 哨兵节点
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[idx]) j --; // 从右往左找比哨兵小的
            while (i < j && arr[i] <= arr[idx]) i ++; // 从左往右找比哨兵大的

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 此时l >= r 交换i与idx
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;

        sort(arr, l, i - 1);
        sort(arr, i + 1, r);
    }
}
