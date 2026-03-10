package com.dflong.algorithm.sort;

public class MergeSort {

    public static void main(String[] args) {
        new MergeSort().sort(new int[]{4,5,6,9,1,2});
    }

    // 合并排序 类似二叉树后序遍历
    void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        for (int i = l; i <= r; i ++) {
            temp[i - l] = arr[i]; // 存在临时数组
        }

        int i = 0, j = m + 1 - l; // 都指向首元素
        for (int k = l; k <= r; k ++) {
            if (i == m + 1 - l) {
                arr[k] = temp[j ++];
            } else if (j == r + 1 - l) {
                arr[k] = temp[i ++];
            } else if (temp[i] < temp[j]) {
                arr[k] = temp[i ++];
            } else {
                arr[k] = temp[j ++];
            }
        }
    }
}
