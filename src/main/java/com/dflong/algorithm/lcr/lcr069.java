package com.dflong.algorithm.lcr;

public class lcr069 {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3) {
            return 1;
        }
        // 肯定不是 0 和 arr.length - 1
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
