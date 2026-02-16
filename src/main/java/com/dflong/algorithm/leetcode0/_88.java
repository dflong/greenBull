package com.dflong.algorithm.leetcode0;

import java.util.Arrays;

public class _88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[index ++] = nums1[i];
                i ++;
            } else {
                res[index ++] = nums2[j];
                j ++;
            }
        }
        while (i < m) {
            res[index ++] = nums1[i];
            i ++;
        }
        while (j < n) {
            res[index ++] = nums2[j];
            j ++;
        }
        for (int k = 0; k < index; k++) {
            nums1[k] = res[k];
        }
    }
}
