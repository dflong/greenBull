package com.dflong.algorithm.sort;

public class BubbleSort {

    // 冒泡排序
    void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    flag = true;
                }
            }
            if (!flag) { // 这轮没有发生过交换，就提前结束
                return;
            }
        }
    }
}
