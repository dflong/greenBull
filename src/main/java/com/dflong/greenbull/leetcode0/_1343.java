package com.dflong.greenbull.leetcode0;

public class _1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        double ave = 0;
        for (int i = 0; i < k; i++) {
            ave += arr[i];
        }
        if (ave / k >= threshold) {
            count ++;
        }

        for (int i = k; i < arr.length; i++) {
            ave += arr[i];
            ave -= arr[i - k];
            if (ave / k >= threshold) {
                count ++;
            }
        }
        return count;
    }
}
